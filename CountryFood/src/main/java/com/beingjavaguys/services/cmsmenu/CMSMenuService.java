package com.beingjavaguys.services.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;

public interface CMSMenuService {
	int addMenu(CMSMenuBean cmsMenuBean, HttpServletResponse response);
	CMSMenuBean getMenu(int menuId);
	String uploadMenuImage(String imageName,int menuId,HttpServletResponse response);
}
