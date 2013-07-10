package cwapp.com.cloudwave.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mobile")
public class TestController {
	@RequestMapping(method = RequestMethod.GET,  value="/welcome")
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(method = RequestMethod.GET,  value="/welcome1")
    @ResponseBody
    public Object welcome1(ModelMap model) {
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

    @RequestMapping(method = RequestMethod.GET, value="/json/{id}")
    @ResponseBody
    public List<String> jsontest(@PathVariable("id") String id) {
        List<String> list = new ArrayList<String>();
        if ("1".equals(id)) {
            list.add("电视");
            list.add("洗衣机");
            list.add("冰箱");
            list.add("电脑");
            list.add("汽车");
        } else {
            list.add("空调");
            list.add("自行车");
            list.add("饮水机");
            list.add("热水器");
        }

       return list;
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
            String filename = "d:/temp/"
                    + file.getOriginalFilename().substring(
                    file.getOriginalFilename().lastIndexOf("."));
            File newfile = new File(filename);
            file.transferTo(newfile);
            return ;
        } else {
            return ;
        }


    }
}