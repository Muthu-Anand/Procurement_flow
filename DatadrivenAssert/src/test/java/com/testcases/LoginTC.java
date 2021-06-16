package com.testcases;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import com.excelutils.DataProviderCall;
import com.excelutils.DataProviderCallMap;
import com.excelutils.ReadObjects;
import com.programwrappers.KeywordWrappers;

public class LoginTC  {
	
	KeywordWrappers kw=new KeywordWrappers();
	ReadObjects obj=new ReadObjects();
	
	
	@Test(dataProviderClass = DataProviderCall.class,dataProvider = "fetchAll",enabled = false)
	public void LoginPage(String Browser,String url) throws InterruptedException {
		
		Logger log =Logger.getLogger(LoginTC.class);
	    PropertyConfigurator.configure("Log4j.properties");
		
		kw.launch(Browser);
		 log.info("opening browser");
		kw.getURL(url);
		 log.info("opening browser");
		kw.close();
		
	}
	
	@Test(dataProviderClass = DataProviderCallMap.class,dataProvider = "fetchAll")
	public void LoginPagee(Map<Object, Object> map) throws InterruptedException, IOException {
		

		Logger log =Logger.getLogger(LoginTC.class);
	    PropertyConfigurator.configure("Log4j.properties");
	    
	   
		String Browser1=map.get("Browser").toString();
		System.out.println(Browser1);
		kw.launch(map.get("Browser").toString());
		 log.info("opening browser");
		kw.getURL(map.get("url").toString());
		 log.info("opening browser");
		 
		 String[] signinclick=obj.readlocator("signinbutton").split(":");
		 kw.click(signinclick[0], signinclick[1]);
		 
		 String[] email=obj.readlocator("email").split(":");
		 kw.enterText(email[0], email[1], map.get("email").toString());
		 kw.sleep(4);
		kw.close();
		
	}

}
