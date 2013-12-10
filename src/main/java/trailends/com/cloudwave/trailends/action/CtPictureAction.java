package com.cloudwave.trailends.action;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.fwapp.base.action.AppAction;
import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.service.FileEntityService;
import com.cloudwave.fwapp.web.ResponseEntity;
import com.cloudwave.trailends.domain.CtPicture;
import com.cloudwave.trailends.service.CtPictureService;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-18 下午3:39:44
 * 处理文件操作
 */

@Controller
@RequestMapping("/picture")
public class CtPictureAction extends AppAction {
	
	@Resource
	private CtPictureService ctPictureService;
	@Resource
	private FileEntityService fileEntityService;
	
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
        	this.fileEntityService.save(fe);
            rm.setResponseMessage(ResponseEntity.SUCCESS, "OK");
            return rm;
        } else {
        	rm.setInfo("未获取到文件, 上传文件失败！");
            return rm;
        }
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
