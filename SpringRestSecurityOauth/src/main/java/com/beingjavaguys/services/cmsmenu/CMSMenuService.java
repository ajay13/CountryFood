package com.beingjavaguys.services.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;

public interface CMSMenuService {
	void addMenu(CMSMenuBean cmsMenuBean, HttpServletResponse response);
}
