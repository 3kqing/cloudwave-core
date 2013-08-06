package com.cloudwave.cycletrail.text.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/text")
public class CtTextAction {

	@RequestMapping(method = RequestMethod.POST,  value="/save")
	public void save() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/search")
	public void search() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/find")
	public void find() {
		
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/get/{id}")
	public void get() {
		
	}
}
