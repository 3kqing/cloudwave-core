package com.cloudwave.fwapp.module.mapper;

import com.cloudwave.fwapp.base.dao.Mapper;
import com.cloudwave.fwapp.module.domain.FileEntity;

public interface FileEntityMapper extends Mapper {

	public FileEntity get(String id);

	public void insert(FileEntity f);
}
