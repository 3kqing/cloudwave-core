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
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.cycletrail.domain.CtTravelMessage;
import com.cloudwave.cycletrail.service.CtTravelMessageService;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.module.domain.User;
import com.cloudwave.fwapp.web.ResponseEntity;

@Controller
@RequestMapping("/travelmessage")
public class CtTravleMessageAction extends AbstractAction {
	//定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger logger = LoggerFactory.getLogger(CtTravleMessageAction.class); 
    
	@Resource
	private CtTravelMessageService ctTravelMessageService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/add")
	public ResponseEntity add(@ModelAttribute("ctTravelMessage") CtTravelMessage tm) {
		ResponseEntity re = new ResponseEntity();
		User u = new User();
		u.setId(1l);
		
		tm.setId(1l);
		tm.setSendTime(new Date());
		tm.setUser(u);
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
	public ResponseEntity loadNewest() {
		ResponseEntity re = new ResponseEntity();
		int count = 10;
		
		List<CtTravelMessage> tmList = this.ctTravelMessageService.load(count);
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
		
		List<CtTravelMessage> tmList = this.ctTravelMessageService.load(count);
		if (CollectionUtils.isNotEmpty(tmList)) {
			re.setData(tmList, ResponseEntity.SUCCESS);
		} else {
			re.setCode(ResponseEntity.WARN);
		}
		
		return re;
	}
	
}
