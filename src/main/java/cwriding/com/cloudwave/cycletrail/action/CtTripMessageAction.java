package com.cloudwave.cycletrail.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.cycletrail.service.CtTripMessageService;
import com.cloudwave.cycletrail.utils.StaticsVariable;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.service.FileEntityService;
import com.cloudwave.fwapp.web.ResponseEntity;

/**
 * 
 * @author DolphinBoy
 * 2013年8月4日 下午5:57:57
 * 校验参考: http://www.cnblogs.com/rollenholt/archive/2012/12/27/2836374.html
 */
@Controller
@RequestMapping("/tripmsg")
public class CtTripMessageAction extends AbstractAction {
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(CtTripMessageAction.class); 
    
	@Resource
	private CtTripMessageService ctTravelMessageService;
	@Resource
	private FileEntityService fileEntityService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity save(@RequestParam("picture") MultipartFile file, @RequestParam("token") String token
			, @Valid CtTripMessage tm , BindingResult result) {
		ResponseEntity re = new ResponseEntity();
		if (result.hasErrors()) {
			re.setCode(ResponseEntity.ERROR, "数据绑定错误!");
			return re;
		}
		tm.setReceiveTime(new Date());
		
		// 这里要考虑两个问题
		// 1.图片的上传信息的保存和CtTripMessage信息的保存是否放在同一个事务里面
		// 2.如果图片上传成功, 但是CtTripMessage信息保存失败时是否要删除本次上传的图片(异步通知以及操作系统)
		
		if (file != null && file.getSize() > 0) {
			FileEntity fe = null;
			try {
				fe = saveFile(file);
			} catch (IOException e) {
				logger.error(e.toString());
				e.printStackTrace();
				re.setCode(ResponseEntity.ERROR, "照片上传错误!");
				return re;
			}
			
			tm.setPath("/upload/" + fe.getSaveName());
	        if (fe != null) {
	            //保存文件上传信息到数据库
	        	try {
	        		this.fileEntityService.save(fe);
	    		} catch (Exception e) {
	    			re.setCode(ResponseEntity.ERROR, "保存照片失败!");
	    			logger.error(e.toString());
	    			e.printStackTrace();
	    		}
	        }
	        tm.setFile(fe);
		} else {
			re.setCode(ResponseEntity.ERROR, "获取照片失败!");
//			return re;
		}
			
//		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//		
//		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
//			try {
//				saveFile(entity.getValue());
//			} catch (IOException e) {
//				logger.error(e.toString());
//				e.printStackTrace();
//				re.setCode(ResponseEntity.ERROR, "照片上传错误!");
//				return re;
//			}
//		}
		
		try {
			this.ctTravelMessageService.save(tm);
		} catch (Exception e) {
			re.setCode(ResponseEntity.ERROR, "保存数据失败!");
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		re.setCode(ResponseEntity.SUCCESS);
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/{id}")
	public ResponseEntity get(@PathVariable("id") Long id) {
		ResponseEntity re = new ResponseEntity();
		if (id == null) {
			re.setCode(ResponseEntity.WARN, "ID不能为空!");
			return re;
		}
		CtTripMessage tm = this.ctTravelMessageService.get(id);
		if (tm != null) {
			re.setData(tm, ResponseEntity.SUCCESS);
			return re;
		} else {
			re.setCode(ResponseEntity.WARN, "没有获取到数据!");
			return re;
		}
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/newer")
	public ResponseEntity loadNewer(@RequestParam("id") Long id) {
		ResponseEntity re = new ResponseEntity();
		List<CtTripMessage> tmList = null;
		if (id == null) {
			tmList = ctTravelMessageService.loadNewest(StaticsVariable.ONCE_REQEST_COUNT);
		} else {
			tmList = this.ctTravelMessageService.loadNewer(StaticsVariable.ONCE_REQEST_COUNT, id);
		}
		
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN, "木有更多数据啦~");
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/older")
	public ResponseEntity loadOlder(@RequestParam("id") Long id) {
		ResponseEntity re = new ResponseEntity();
		List<CtTripMessage> tmList = null;
		if (id != null) {
			tmList = this.ctTravelMessageService.loadOrder(StaticsVariable.ONCE_REQEST_COUNT, id);
		} else {
			tmList = this.ctTravelMessageService.loadNewest(StaticsVariable.ONCE_REQEST_COUNT);
		}
		
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN, "木有更多数据啦~");
		}
		
		return re;
	}
	
	//数据绑定
//    @InitBinder    
//    public void initBinder(WebDataBinder binder) {  
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
//        dateFormat.setLenient(false);    
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
//        //CustomDateEditor 可以换成自己定义的编辑器。  
//          
//        //注册一个Date 类型的绑定器 。  
//    }
}
