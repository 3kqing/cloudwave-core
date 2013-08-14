package com.cloudwave.cycletrail.text.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.cycletrail.text.domain.CtText;
import com.cloudwave.cycletrail.text.service.CtTextService;
import com.cloudwave.fw.app.domain.User;

@Controller
@RequestMapping("/text")
public class CtTextAction {

	@Resource
	private CtTextService ctTextService;
	
	
	@RequestMapping(method = RequestMethod.POST,  value="/save")
	public void save(@ModelAttribute("ctText") CtText t) {
		User u = new User();
		u.setId("1");
		
		t.setId("11");
//		t.setContent("测试文本");
		t.setUser(u);
		this.ctTextService.save(t);
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
		System.out.println(this.ctTextService.get("1"));
		List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");
        list.add("电脑");
        list.add("汽车");
        return list;
	}
}
