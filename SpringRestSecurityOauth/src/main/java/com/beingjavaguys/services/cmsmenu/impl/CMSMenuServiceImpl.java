package com.beingjavaguys.services.cmsmenu.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;
import com.beingjavaguys.dao.cmscooks.CMSCooksDao;
import com.beingjavaguys.dao.cmsmenu.CMSMenuCatagoryDao;
import com.beingjavaguys.dao.cmsmenu.CMSMenuDao;
import com.beingjavaguys.models.cmscooks.CMSCooksData;
import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;
import com.beingjavaguys.services.cmsmenu.CMSMenuService;
import com.beingjavaguys.utility.cmsmenu.CMSMenuUtility;

@Service("cmsMenuService")
public class CMSMenuServiceImpl implements CMSMenuService {

	@Autowired
	CMSMenuUtility cmsMenuUtility;

	@Autowired
	CMSMenuDao cmsMenuDao;

	@Autowired
	CMSMenuCatagoryDao cmsMenuCatagoryDao;

	@Autowired
	CMSCooksDao cmsCooksDao;

	@Override
	public int addMenu(CMSMenuBean cmsMenuBean, HttpServletResponse response) {
		CMSMenuData cmsMenuData = null;
		cmsMenuData = cmsMenuUtility.populateCMSMenuData(cmsMenuBean);

		CMSMenuCatagoryData cmsMenuCatagoryData = cmsMenuCatagoryDao.getCatagory(cmsMenuBean.getMenuCatagoryId(),
				response);
		cmsMenuData.setCmsMenuCatagoryData(cmsMenuCatagoryData);

		CMSCooksData cmsCooksData = cmsCooksDao.getCooks(cmsMenuBean.getCooksId(), response);
		cmsMenuData.setCmsCooksData(cmsCooksData);

		return cmsMenuDao.addMenu(cmsMenuData, response);
	}

	@Override
	public CMSMenuBean getMenu(int menuId) {
		CMSMenuData cmsMenuData = cmsMenuDao.getMenu(menuId);
		CMSMenuBean cmsMenuBean = cmsMenuUtility.populateCMSMenuBean(cmsMenuData);
		return cmsMenuBean;
	}

	@Override
	public String uploadMenuImage(String imageName,int menuId,HttpServletResponse response) {
		CMSMenuData cmsMenuData = cmsMenuDao.getMenu(menuId);
		String previousFilePath = cmsMenuData.getMenuImagePath();
		cmsMenuData.setMenuImagePath(imageName);
		cmsMenuDao.updateMenu(cmsMenuData, response);
		return previousFilePath;
	}

}
