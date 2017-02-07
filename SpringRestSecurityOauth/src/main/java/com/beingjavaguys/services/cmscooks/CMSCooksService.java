package com.beingjavaguys.services.cmscooks;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.bean.cmscooks.CMSCooksBean;

public interface CMSCooksService {
	void addCooks(CMSCooksBean cmsCooksBean, HttpServletResponse response);

	void deleteCooks(int id, HttpServletResponse response);
}
