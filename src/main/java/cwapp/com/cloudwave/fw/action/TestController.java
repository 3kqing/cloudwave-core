package com.cloudwave.fw.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cloudwave.fw.action.base.ResponseEntity;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * 
 * TODO
 * @author DolphinBoy
 * 2013-8-6 下午10:40:28
 * springmvc:  http://www.oschina.net/code/snippet_1165954_23354
 */
@Controller
@RequestMapping("/mobile")
public class TestController {
	@RequestMapping(method = RequestMethod.GET,  value="/welcome")
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(method = RequestMethod.POST,  value="/text")
    public void newtext(HttpServletRequest request) {
        System.out.print("新增文本！");
        String token = request.getParameter("token");
        String text = request.getParameter("data");
        System.out.print(token);
        System.out.print(text);
    }

    @RequestMapping(method = RequestMethod.GET, value="/json/{id}")
    @ResponseBody
    public Object jsontest(@PathVariable("id") String id) {
        List<String> list = new ArrayList<String>();
        if ("1".equals(id)) {
            list.add("电视");
            list.add("洗衣机");
            list.add("冰箱");
            list.add("电脑");
            list.add("汽车");
            return list;

        } else {
//            return getDate();
        }

        ResponseEntity rm = new ResponseEntity(ResponseEntity.SUCCESS, "OK");
        rm.setData(list);
        return rm;
    }
    @JsonSerialize(using = CustomDateSerializer.class)
    private List<Date> getDate() {
        List<Date> dList = new ArrayList<Date>();
        dList.add(new Date());
        dList.add(new Date());
        dList.add(new Date());
        dList.add(new Date());
        return dList;
    }

    @RequestMapping(method = RequestMethod.GET, value="/json1")
    public ModelAndView jsonTest1() {
        ModelAndView mv = new ModelAndView("json");

        List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");
        list.add("电脑");
        list.add("汽车");
        list.add("空调");
        list.add("自行车");
        list.add("饮水机");
        list.add("热水器");

        mv.addObject(list);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value="/json2",
            headers="Accept=text/html, application/xml, application/json")
    public Object xmlTest() {
        List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");
        list.add("电脑");
        list.add("汽车");
        list.add("空调");
        list.add("自行车");
        list.add("饮水机");
        list.add("热水器");
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, value="/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
        
    	if (!file.isEmpty()) {
            String type = file.getContentType();
            String filename = file.getOriginalFilename();
            String newfilename = "F:/Temp/"+ UUID.randomUUID()
                    + filename.substring(filename.lastIndexOf("."));
            File newfile = new File(newfilename);
            file.transferTo(newfile);
            return ;
        } else {
            return ;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/upload/picture")
    @ResponseBody
    public ResponseEntity uploadPicture(@RequestParam("file") MultipartFile file) {
        ResponseEntity rm = new ResponseEntity(ResponseEntity.ERROR);
        List<String> list = new ArrayList<String>();
        list.add("电视");
        list.add("洗衣机");
        list.add("冰箱");

        rm.setData(list);
        rm.setResponseMessage(ResponseEntity.SUCCESS, "OK");
        return rm;
    }
}

class CustomDateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date value, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(value);
        jgen.writeString(formattedDate);
    }

}
