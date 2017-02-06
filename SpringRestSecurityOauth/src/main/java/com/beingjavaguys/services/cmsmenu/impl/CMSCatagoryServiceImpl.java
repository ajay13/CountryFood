package com.beingjavaguys.services.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.bean.cmsmenu.CMSCatagoryBean;
import com.beingjavaguys.dao.cmsmenu.CMSMenuCatagoryDao;
import com.beingjavaguys.services.cmsmenu.CMSCatagoryService;

@Service("cmsCatagoryService")
public class CMSCatagoryServiceImpl implements CMSCatagoryService{

	@Autowired
	CMSMenuCatagoryDao cmsMenuCatagoryDao; 
	
	@Override
	public void addCatagory(CMSCatagoryBean cmsCatagoryBean, HttpServletResponse response) {
		
	}

}
