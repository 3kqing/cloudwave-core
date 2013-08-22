package com.cloudwave.cycletrail.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudwave.cycletrail.service.CtTravelNotesService;
import com.cloudwave.fwapp.base.action.AbstractAction;

@Controller
@RequestMapping("/travelnotes")
public class CtTravelNotesAction extends AbstractAction {
	
	@Resource
	private CtTravelNotesService ctTravelNotesService;
	
	
}
