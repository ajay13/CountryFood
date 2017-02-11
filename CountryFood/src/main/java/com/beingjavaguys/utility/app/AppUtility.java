package com.beingjavaguys.utility.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component("appUtility")
public class AppUtility {
	InputStream inputStream;

	public Properties loadPropertyFile(String propFileName) {
		Properties properties = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		if (inputStream != null) {
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
}
