package com.beingjavaguys.utility.cmscooks;

import org.springframework.stereotype.Component;

import com.beingjavaguys.bean.cmscooks.CMSCooksBean;
import com.beingjavaguys.models.cmscooks.CMSCooksData;

@Component("cmsCooksUtility")
public class CMSCooksUtility {
	public CMSCooksData populateCMSCooks(CMSCooksBean cmsCooksBean) {
		CMSCooksData cmsCooksData = new CMSCooksData();

		cmsCooksData.setName(cmsCooksBean.getName());
		cmsCooksData.setDescription(cmsCooksBean.getDescription());
		return cmsCooksData;
	}
}
