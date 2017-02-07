package com.beingjavaguys.utility.cmsmenu;

import org.springframework.stereotype.Component;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;
import com.beingjavaguys.models.cmsmenu.CMSMenuData;

@Component("cmsMenuUtility")
public class CMSMenuUtility {
	public CMSMenuData populateCMSMenuData(CMSMenuBean cmsMenuBean) {
		CMSMenuData cmsMenuData = new CMSMenuData();

		cmsMenuData.setItemName(cmsMenuBean.getItemName());
		cmsMenuData.setDescription(cmsMenuBean.getDescription());
		cmsMenuData.setPrice(cmsMenuBean.getPrice());
		return cmsMenuData;
	}
}
