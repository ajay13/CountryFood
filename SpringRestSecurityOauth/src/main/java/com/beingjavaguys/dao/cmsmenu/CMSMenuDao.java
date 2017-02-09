package com.beingjavaguys.dao.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;

public interface CMSMenuDao {
	public int addMenu(CMSMenuData cmsMenuData,HttpServletResponse response);
	CMSMenuData getMenu(int menuId);
	public void updateMenu(CMSMenuData cmsMenuData, HttpServletResponse response);
}
