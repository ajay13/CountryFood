package com.beingjavaguys.dao.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;

public interface CMSMenuCatagoryDao {
	public void addCatagory(CMSMenuCatagoryData cmsMenuCatagoryData,HttpServletResponse response);

	public void deleteCatagory(CMSMenuCatagoryData cmsMenuCatagoryData, HttpServletResponse response);
	
	public CMSMenuCatagoryData getCatagory(int id,HttpServletResponse response);
}
