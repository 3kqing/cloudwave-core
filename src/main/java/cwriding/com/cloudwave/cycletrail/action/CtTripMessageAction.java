package com.cloudwave.cycletrail.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.cycletrail.service.CtTravelMessageService;
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
	private CtTravelMessageService ctTravelMessageService;
	@Resource
	private FileEntityService fileEntityService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public ResponseEntity add(@Valid CtTripMessage tm
			, BindingResult result) {
		ResponseEntity re = new ResponseEntity();
		if (result.hasErrors()) {
			re.setCode(ResponseEntity.ERROR, "数据绑定错误!");
			return re;
		}
//		this.ctTravelMessageService.save(tm);
		logger.info(JSON.toJSONString(tm));
		re.setData(tm);
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
	public ResponseEntity loadNewest() {
		ResponseEntity re = new ResponseEntity();
		int count = 20;
		
		List<CtTripMessage> tmList = this.ctTravelMessageService.load(count);
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/loadbefore/{count}")
	public ResponseEntity loadBefore(@PathVariable("count") int count
			,@PathVariable("time") Date time) {
		ResponseEntity re = new ResponseEntity();
		
		List<CtTripMessage> tmList = this.ctTravelMessageService.load(count, time);
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
}
