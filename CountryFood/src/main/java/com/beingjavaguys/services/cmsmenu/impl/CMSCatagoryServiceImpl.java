package com.beingjavaguys.services.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.bean.cmsmenu.CMSCatagoryBean;
import com.beingjavaguys.dao.cmsmenu.CMSMenuCatagoryDao;
import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.services.cmsmenu.CMSCatagoryService;
import com.beingjavaguys.utility.cmsmenu.CMSCatagoryUtility;

@Service("cmsCatagoryService")
public class CMSCatagoryServiceImpl implements CMSCatagoryService{

	@Autowired
	CMSMenuCatagoryDao cmsMenuCatagoryDao; 
	
	@Autowired
	CMSCatagoryUtility cmsCatagoryUtility;
	
	@Override
	public void addCatagory(CMSCatagoryBean cmsCatagoryBean, HttpServletResponse response) {
		CMSMenuCatagoryData  cmsMenuCatagoryData = null;
		cmsMenuCatagoryData = cmsCatagoryUtility.populateCMSMenuCatagory(cmsCatagoryBean);
		cmsMenuCatagoryDao.addCatagory(cmsMenuCatagoryData, response);
	}

	@Override
	public void deleteCatagory(int id, HttpServletResponse response) {
		CMSMenuCatagoryData cmsMenuCatagoryData = null;
		cmsMenuCatagoryData = cmsMenuCatagoryDao.getCatagory(id, response);
		cmsMenuCatagoryDao.deleteCatagory(cmsMenuCatagoryData, response);
	}

}
