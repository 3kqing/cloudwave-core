package com.cloudwave.cycletrail.text.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.text.mapper.CtTextMapper;
import com.cloudwave.fw.service.AbstractService;

@Service
public class CtTextService extends AbstractService {

	@Resource
	private CtTextMapper ctTextMapper;
	
	
}
