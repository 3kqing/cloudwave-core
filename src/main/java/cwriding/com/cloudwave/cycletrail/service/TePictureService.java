package com.cloudwave.cycletrail.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtPicture;
import com.cloudwave.cycletrail.mapper.CtPictureMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class TePictureService extends AbstractService {

	@Resource
	private CtPictureMapper ctPictureMapper;

	public CtPicture get(String id) {
		return this.ctPictureMapper.get(id);
	}
	
	public void save(CtPicture p) {
		this.ctPictureMapper.insert(p);
	}
}
