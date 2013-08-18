package com.cloudwave.cycletrail.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.fw.action.base.ResponseEntity;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-18 下午3:39:44
 * 处理文件操作
 */

@Controller
@RequestMapping("/picture")
public class CtPictureAction {

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value="/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		ResponseEntity rm = new ResponseEntity(ResponseEntity.ERROR);
		
        if (!file.isEmpty()) {
            String type = file.getContentType();
            String filename = file.getOriginalFilename();
            String newfilename = "F:/Temp/"+ UUID.randomUUID()
                    + filename.substring(filename.lastIndexOf("."));
            File newfile = new File(newfilename);
            file.transferTo(newfile);
            rm.setResponseMessage(ResponseEntity.SUCCESS, "OK");
            return rm;
        } else {
        	rm.setInfo("未获取到文件, 上传文件失败！");
            return rm;
        }
    }
}
