package com.cloudwave.trailends.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.fwapp.base.action.AppAction;
import com.cloudwave.fwapp.module.domain.User;
import com.cloudwave.fwapp.web.ResponseEntity;
import com.cloudwave.trailends.domain.CtText;
import com.cloudwave.trailends.service.CtTextService;

@Controller
@RequestMapping("/text")
public class CtTextAction extends AppAction {

	@Resource
	private CtTextService ctTextService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,  value="/add")
	public ResponseEntity add(@ModelAttribute("ctText") CtText t) {
		ResponseEntity re = new ResponseEntity();
		User u = new User();
		u.setId(1l);
		
		t.setId(1l);
		t.setTime(new Date());
		t.setUser(u);
		this.ctTextService.save(t);
		re.setCode(ResponseEntity.SAVE_SUCCESS);
		return re;
	}
	
	@RequestMapping(method = RequestMethod.GET,  value="/search")
	public void search() {
		
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/find")
	public Object find() {
		List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");
        list.add("电脑");
        list.add("汽车");
        return list;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET,  value="/{id}")
	public Object load() {
		System.out.println(this.ctTextService.get("1").getId());
		List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");
        list.add("电脑");
        list.add("汽车");
        return list;
	}

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
