package com.beingjavaguys.controllers.cmsmenu;

import java.io.File;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.beingjavaguys.bean.cmsmenu.CMSMenuBean;
import com.beingjavaguys.services.cmsmenu.CMSMenuService;
import com.beingjavaguys.utility.app.AppUtility;

@Controller
@RequestMapping("/cms/menu")
public class CMSMenuController {

	@Autowired
	CMSMenuService cmsMenuService;
	
	@Autowired
	AppUtility appUtility;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody int addMenu(HttpServletResponse response, @RequestBody CMSMenuBean cmsMenuBean) {
		int nenuId = 0;
		try {
			nenuId = cmsMenuService.addMenu(cmsMenuBean, response);
		} catch (Exception e) {
			response.setStatus(400);
		}
		return nenuId;
	}

	@RequestMapping(value = "/fileupload", headers = ("content-type=multipart/*"), method = RequestMethod.POST)
	public @ResponseBody void upload(HttpServletResponse response,@RequestParam("file") MultipartFile inputFile,
			@RequestParam(required = true) int menuid) {
		try {
			Properties properties = appUtility.loadPropertyFile("application.properties");
            String catalinaPath = properties.getProperty("tomcat.path");
			String originalFilename = inputFile.getOriginalFilename();
			String folderPath = catalinaPath+File.separator+"resource"+File.separator+"image"+File.separator+"menu_item"+File.separator;
			String fileName = originalFilename;
			File destinationFile = new File(folderPath+fileName);
			if (!destinationFile.exists()){
				destinationFile.mkdirs();
			}else{
				boolean trigger = true;
				int i = 0;
				while(trigger){
					if(destinationFile.exists()){
						destinationFile = new File(folderPath+i+fileName);
						i++;
					}else{
						trigger = false;
					}
				}
			}
			inputFile.transferTo(destinationFile);
			String prevoiusFileName = cmsMenuService.uploadMenuImage(destinationFile.getName(),menuid,response);
			if(prevoiusFileName!=null && !prevoiusFileName.trim().isEmpty()){
				destinationFile = new File(folderPath+prevoiusFileName);
				destinationFile.delete();
			}
		} catch (Exception e) {
			response.setStatus(400);
		}
	}
}
