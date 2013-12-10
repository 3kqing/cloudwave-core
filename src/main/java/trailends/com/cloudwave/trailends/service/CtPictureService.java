package com.cloudwave.trailends.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.BaseService;
import com.cloudwave.trailends.domain.CtPicture;
import com.cloudwave.trailends.mapper.CtPictureMapper;

@Service
public class CtPictureService extends BaseService {

	@Resource
	private CtPictureMapper ctPictureMapper;

	public CtPicture get(String id) {
		return this.ctPictureMapper.get(id);
	}
	
	public void save(CtPicture p) {
		this.ctPictureMapper.insert(p);
	}
}
