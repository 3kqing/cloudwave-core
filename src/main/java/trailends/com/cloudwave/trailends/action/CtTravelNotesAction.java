package com.cloudwave.trailends.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloudwave.fwapp.base.action.AppAction;
import com.cloudwave.trailends.service.CtTravelNotesService;

@Controller
@RequestMapping("/travelnotes")
public class CtTravelNotesAction extends AppAction {
	
	@Resource
	private CtTravelNotesService ctTravelNotesService;

	@Override
	public void list() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		
	}
	
	
}
