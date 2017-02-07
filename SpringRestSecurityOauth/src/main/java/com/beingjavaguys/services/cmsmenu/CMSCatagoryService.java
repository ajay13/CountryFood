package com.beingjavaguys.services.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.bean.cmsmenu.CMSCatagoryBean;

public interface CMSCatagoryService {
	void addCatagory(CMSCatagoryBean cmsCatagoryBean, HttpServletResponse response);

	void deleteCatagory(int id, HttpServletResponse response);
}
