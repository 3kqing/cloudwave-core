package com.cloudwave.fwapp.base.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.cloudwave.fwapp.module.domain.FileEntity;


/**
 * @description 抽象业务Action
 * @author DolphinBoy
 * @date 
 * @TODO 定义了通用的抽象业务方法
 */
public abstract class AppAction extends BaseAction {
	
    
	protected FileEntity saveFile(MultipartFile file) throws IllegalStateException, IOException {
		if (!file.isEmpty()) {
			FileEntity fe = new FileEntity();
			
            String contentType = file.getContentType();
            String type = file.getName().substring(file.getName().indexOf(".")+1, file.getName().length());
            
            String fileName = file.getOriginalFilename();
//            String path = "F:/Temp/";
            // 这里的命名规则应该是: 用户ID+年+随机文件名
            String path = "E:/WorkSpace/EclipseProject/cwfw-core/src/main/webapp/upload//";
            String saveName = UUID.randomUUID()
                    + fileName.substring(fileName.lastIndexOf("."));
            String savePath = path + saveName;
            
            fe.setName(fileName);
            fe.setSaveName(saveName);
            fe.setSavePath(savePath);
            fe.setContentType(contentType);
            fe.setType(type);
            fe.setUploadTime(new Date());
            fe.setMd5("");
            
            File newfile = new File(savePath);
            
            file.transferTo(newfile);
            
            return fe;
		} else {
			return null;
		}
	}
	
	public abstract void list();
	
//	public abstract void add();
	
	public abstract void save();
	
//	public abstract void edit();
	
	public abstract void update();
	
	public abstract void delete();
	
	public abstract void view();
	
}
