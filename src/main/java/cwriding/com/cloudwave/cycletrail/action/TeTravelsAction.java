package com.cloudwave.cycletrail.action;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.cycletrail.domain.CtTravels;
import com.cloudwave.cycletrail.service.TeTravelsService;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.base.entity.ResultEntity;
import com.cloudwave.fwapp.web.ResponseEntity;
import com.cloudwave.trailends.entity.TravelsBean;

@Controller
@RequestMapping("/travels")
public class TeTravelsAction extends AbstractAction {
	private final static Logger logger = LoggerFactory.getLogger(TeTravelsAction.class); 
	
	@Resource
	private TeTravelsService ctTravelsService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity save(@Valid TravelsBean tm, BindingResult result) {
		ResponseEntity re = new ResponseEntity();
		if (result.hasErrors()) {
			re.setCode(ResponseEntity.ERROR, "数据绑定错误!");
			return re;
		}
		
		ResultEntity r = tm.toTravels();
		if (ResultEntity.FAIL.equals(r.getCode())) {
			return re.parseResult(r);
		}
		CtTravels t = (CtTravels) r.getData();
		
		try {
			this.ctTravelsService.save(t);
		} catch (Exception e) {
			re.setCode(ResponseEntity.ERROR, "保存数据失败!");
			logger.error(e.getLocalizedMessage());
			logger.debug(e.getLocalizedMessage());
		}
		
		return re;
	}
	
}
