package com.beingjavaguys.controllers.cmscooks;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beingjavaguys.bean.cmscooks.CMSCooksBean;
import com.beingjavaguys.services.cmscooks.CMSCooksService;

@Controller
@RequestMapping("/cms/cooks")
public class CMSCooksContoller {

	@Autowired
	CMSCooksService cmsCooksService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	void addCatagory(HttpServletResponse response,
			@RequestBody CMSCooksBean cmsCooksBean) {
		try {
			cmsCooksService.addCooks(cmsCooksBean,response);
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody
	void addCatagory(HttpServletResponse response,
			@RequestParam(required=true) int id) {
		try {
			cmsCooksService.deleteCooks(id,response);
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
	
	
}
