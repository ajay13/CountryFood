package com.beingjavaguys.controllers.cmsmenu;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beingjavaguys.bean.cmsmenu.CMSCatagoryBean;
import com.beingjavaguys.services.cmsmenu.CMSCatagoryService;

@Controller
@RequestMapping("/cmsmenu/catagory")
public class CMSMenuCatagoryController {

	@Autowired
	CMSCatagoryService cmsCatagoryService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void addCatagory(HttpServletResponse response,
			@RequestBody CMSCatagoryBean cmsCatagoryBean) {
		try {
			cmsCatagoryService.addCatagory(cmsCatagoryBean,response);
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
}
