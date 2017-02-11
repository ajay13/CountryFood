package com.beingjavaguys.services.cmscooks.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beingjavaguys.bean.cmscooks.CMSCooksBean;
import com.beingjavaguys.dao.cmscooks.CMSCooksDao;
import com.beingjavaguys.models.cmscooks.CMSCooksData;
import com.beingjavaguys.services.cmscooks.CMSCooksService;
import com.beingjavaguys.utility.cmscooks.CMSCooksUtility;

@Service("cmsCooksService")
public class CMSCooksServiceImpl implements CMSCooksService {

	@Autowired
	CMSCooksDao cmsCooksDao;

	@Autowired
	CMSCooksUtility cmsCooksUtility;

	@Override
	public void addCooks(CMSCooksBean cmsCooksBean, HttpServletResponse response) {
		CMSCooksData cmsCooksData = null;
		cmsCooksData = cmsCooksUtility.populateCMSCooks(cmsCooksBean);
		cmsCooksDao.addCooks(cmsCooksData, response);
	}

	@Override
	public void deleteCooks(int id, HttpServletResponse response) {
		CMSCooksData cmsCooksData = null;
		cmsCooksData = cmsCooksDao.getCooks(id, response);
		cmsCooksDao.deleteCooks(cmsCooksData, response);
	}

}
