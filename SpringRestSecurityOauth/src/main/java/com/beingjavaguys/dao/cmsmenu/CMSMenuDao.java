package com.beingjavaguys.dao.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;

public interface CMSMenuDao {
	public void addMenu(CMSMenuData cmsMenuData,HttpServletResponse response);
}
