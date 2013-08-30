package com.cloudwave.cycletrail.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.cycletrail.domain.CtTravelMessage;
import com.cloudwave.cycletrail.service.CtTravelMessageService;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.domain.User;
import com.cloudwave.fwapp.module.service.FileEntityService;
import com.cloudwave.fwapp.web.ResponseEntity;

@Controller
@RequestMapping("/travelmessage")
public class CtTravleMessageAction extends AbstractAction {
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(CtTravleMessageAction.class); 
    
	@Resource
	private CtTravelMessageService ctTravelMessageService;
	@Resource
	private FileEntityService fileEntityService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/add")
	public ResponseEntity add(@RequestParam("file") MultipartFile file, 
			@ModelAttribute("ctTravelMessage") CtTravelMessage tm) {
		ResponseEntity re = new ResponseEntity();
		User u = new User();
		u.setId(1l);
		
		tm.setId(1l);
		tm.setSendTime(new Date());
		tm.setUser(u);
		if (file != null) {
			FileEntity fe = saveFile(file);
			tm.setPath("/upload/" + fe.getSaveName());
	        if (fe != null) {
	            
	            //保存 fe 到数据库
//	        	this.fileEntityService.save(fe);
	        	
	        }
		}
        this.ctTravelMessageService.save(tm);
		re.setCode(ResponseEntity.SAVE_SUCCESS);
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/{id}")
	public ResponseEntity get(@PathVariable("id") String id) {
		ResponseEntity re = new ResponseEntity();
		
		CtTravelMessage tm = this.ctTravelMessageService.get(id);
		if (tm != null) {
			re.setData(tm, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/loadnewest")
	public ResponseEntity loadNewest(@PathVariable("date") Date time) {
		ResponseEntity re = new ResponseEntity();
		int count = 20;
		
		List<CtTravelMessage> tmList = this.ctTravelMessageService.load(count, time);
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
		
		List<CtTravelMessage> tmList = this.ctTravelMessageService.load(count, time);
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
}
