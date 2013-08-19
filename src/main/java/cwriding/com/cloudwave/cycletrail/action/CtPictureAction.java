package com.cloudwave.cycletrail.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.cycletrail.domain.CtPicture;
import com.cloudwave.cycletrail.service.CtPictureService;
import com.cloudwave.fwapp.base.action.AbstractAction;
import com.cloudwave.fwapp.base.domain.FileEntity;
import com.cloudwave.fwapp.web.ResponseEntity;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-18 下午3:39:44
 * 处理文件操作
 */

@Controller
@RequestMapping("/picture")
public class CtPictureAction extends AbstractAction {
	
	@Resource
	private CtPictureService ctPictureService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/load")
	public ResponseEntity load(@PathVariable("id") String id) {
		ResponseEntity rm = new ResponseEntity(ResponseEntity.ERROR);
		
		CtPicture pic = this.ctPictureService.get(id);
		if (pic == null) {
			rm.setResponseMessage(ResponseEntity.FAIL, "找不到图片");
			return rm;
		}
		rm.setData(pic, ResponseEntity.SUCCESS);
		return rm;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value="/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file
    		,@ModelAttribute CtPicture pic) throws IllegalStateException, IOException {
		ResponseEntity rm = new ResponseEntity(ResponseEntity.ERROR);
		
		this.ctPictureService.save(pic);
		
		FileEntity fe = saveFile(file);
        if (fe != null) {
            
            //保存 fe 到数据库
        	
            rm.setResponseMessage(ResponseEntity.SUCCESS, "OK");
            return rm;
        } else {
        	rm.setInfo("未获取到文件, 上传文件失败！");
            return rm;
        }
    }
	
	protected FileEntity saveFile(MultipartFile file) {
		if (!file.isEmpty()) {
			FileEntity fe = new FileEntity();
			
            String contentType = file.getContentType();
            String type = file.getName().substring(file.getName().indexOf(".")+1, file.getName().length());
            
            String filename = file.getOriginalFilename();
            String newfilename = "F:/Temp/"+ UUID.randomUUID()
                    + filename.substring(filename.lastIndexOf("."));
            
            fe.setName(filename);
            fe.setSaveName(newfilename);
            fe.setContentType(contentType);
            fe.setType(type);
            fe.setUploadTime(new Date());
            fe.setMd5("");
            
            File newfile = new File(newfilename);
            try {
				file.transferTo(newfile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return fe;
		} else {
			return null;
		}
	}
	
}
