package com.beingjavaguys.controllers.cmsmenu;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;
import com.beingjavaguys.services.cmsmenu.CMSMenuService;

@Controller
@RequestMapping("/cms/menu")
public class CMSMenuController {

	CMSMenuService cmsMenuService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody void addMenu(HttpServletResponse response, @RequestBody CMSMenuBean cmsMenuBean) {
		try {
			cmsMenuService.addMenu(cmsMenuBean, response);
		} catch (Exception e) {
			response.setStatus(400);
		}
	}

	@RequestMapping(value = "/fileupload", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void upload(HttpServletResponse response,@RequestParam("file") MultipartFile inputFile) {
		try {
			
			String originalFilename = inputFile.getOriginalFilename();
			File destinationFile = new File(File.separator + originalFilename);
			inputFile.transferTo(destinationFile);
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
}
