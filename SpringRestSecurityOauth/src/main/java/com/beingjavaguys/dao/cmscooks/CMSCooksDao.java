package com.beingjavaguys.dao.cmscooks;

import javax.servlet.http.HttpServletResponse;

import com.beingjavaguys.models.cmscooks.CMSCooksData;

public interface CMSCooksDao {
	public void addCooks(CMSCooksData cmsCooksData,HttpServletResponse response);

	public void deleteCooks(CMSCooksData cmsCooksData, HttpServletResponse response);
	
	public CMSCooksData getCooks(int id,HttpServletResponse response);
}
