package com.cloudwave.cycletrail.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.cycletrail.service.CtTripMessageService;
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
	public ResponseEntity save(@Valid CtTripMessage tm
			, BindingResult result) {
		ResponseEntity re = new ResponseEntity();
		if (result.hasErrors()) {
			re.setCode(ResponseEntity.ERROR, "数据绑定错误!");
			return re;
		}
		tm.setReceiveTime(new Date());
		try {
			this.ctTravelMessageService.save(tm);
		} catch (Exception e) {
			re.setCode(ResponseEntity.ERROR, "保存数据时产生错误!");
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		re.setCode(ResponseEntity.SUCCESS);
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/upload")
	public ResponseEntity add(@RequestParam("file") MultipartFile file, 
			@ModelAttribute("ctTravelMessage") CtTripMessage tm) {
		ResponseEntity re = new ResponseEntity();
		
		if (file != null) {
			FileEntity fe = saveFile(file);
			tm.setPath("/upload/" + fe.getSaveName());
	        if (fe != null) {
	            //保存 fe 到数据库
	        	this.fileEntityService.save(fe);
	        }
	        tm.setFile(fe);
		}
		
        this.ctTravelMessageService.save(tm);
		re.setCode(ResponseEntity.SAVE_SUCCESS);
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/{id}")
	public ResponseEntity get(@PathVariable("id") String id) {
		ResponseEntity re = new ResponseEntity();
		
		CtTripMessage tm = this.ctTravelMessageService.get(id);
		if (tm != null) {
			re.setData(tm, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/newest")
	public ResponseEntity loadNewest(@PathVariable("tmid") Long tmId) {
		ResponseEntity re = new ResponseEntity();
		int num = 50;
		
		List<CtTripMessage> tmList = this.ctTravelMessageService.loadNewer(num, tmId);
		
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/older")
	public ResponseEntity loadOlder(@PathVariable("tmid") Long tmId) {
		ResponseEntity re = new ResponseEntity();
		int num = 50;
		
		List<CtTripMessage> tmList = this.ctTravelMessageService.loadOrder(num, tmId);
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
	//数据绑定
    @InitBinder    
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
        dateFormat.setLenient(false);    
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
        //CustomDateEditor 可以换成自己定义的编辑器。  
          
        //注册一个Date 类型的绑定器 。  
    } 
}
