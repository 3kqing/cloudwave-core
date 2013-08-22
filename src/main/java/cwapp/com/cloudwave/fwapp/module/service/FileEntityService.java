package com.cloudwave.fwapp.module.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.AbstractService;
import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.mapper.FileEntityMapper;

@Service
public class FileEntityService extends AbstractService {

	@Resource
	private FileEntityMapper fileEntityMapper;

	public FileEntity get(String id) {
		return this.fileEntityMapper.get(id);
	}
	
	public void save(FileEntity f) {
		this.fileEntityMapper.insert(f);
	}
}
