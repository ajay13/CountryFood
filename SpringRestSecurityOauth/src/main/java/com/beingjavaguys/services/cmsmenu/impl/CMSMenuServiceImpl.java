package com.beingjavaguys.services.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;
import com.beingjavaguys.dao.cmscooks.CMSCooksDao;
import com.beingjavaguys.dao.cmsmenu.CMSMenuCatagoryDao;
import com.beingjavaguys.dao.cmsmenu.CMSMenuDao;
import com.beingjavaguys.models.cmscooks.CMSCooksData;
import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;
import com.beingjavaguys.services.cmsmenu.CMSMenuService;
import com.beingjavaguys.utility.cmsmenu.CMSMenuUtility;

public class CMSMenuServiceImpl implements CMSMenuService{

	@Autowired
	CMSMenuUtility cmsMenuUtility;
	
	@Autowired
	CMSMenuDao cmsMenuDao;
	
	@Autowired
	CMSMenuCatagoryDao cmsMenuCatagoryDao;
	
	@Autowired
	CMSCooksDao cmsCooksDao;
	
	@Override
	public void addMenu(CMSMenuBean cmsMenuBean, HttpServletResponse response) {
		CMSMenuData  cmsMenuData = null;
		cmsMenuData = cmsMenuUtility.populateCMSMenuData(cmsMenuBean);
		
		CMSMenuCatagoryData cmsMenuCatagoryData = cmsMenuCatagoryDao.getCatagory(cmsMenuBean.getMenuCatagoryId(), response);
		cmsMenuData.setCmsMenuCatagoryData(cmsMenuCatagoryData);
		
		CMSCooksData cmsCooksData = cmsCooksDao.getCooks(cmsMenuBean.getCooksId(), response);
		cmsMenuData.setCmsCooksData(cmsCooksData);
		
		cmsMenuDao.addMenu(cmsMenuData, response);
	}

}
