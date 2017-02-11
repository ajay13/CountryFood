package com.beingjavaguys.utility.cmsmenu;

import org.springframework.stereotype.Component;

import com.beingjavaguys.bean.cmsmenu.CMSCatagoryBean;
import com.beingjavaguys.models.cmsmenu.CMSMenuCatagoryData;

@Component("cmsCatagoryUtility")
public class CMSCatagoryUtility {
	public CMSMenuCatagoryData populateCMSMenuCatagory(CMSCatagoryBean cmsCatagoryBean) {
		CMSMenuCatagoryData cmsMenuCatagoryData = new CMSMenuCatagoryData();

		cmsMenuCatagoryData.setName(cmsCatagoryBean.getName());
		return cmsMenuCatagoryData;
	}
}
