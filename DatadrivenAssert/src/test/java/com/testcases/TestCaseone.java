package com.testcases;

import org.testng.annotations.Test;

import com.excelutils.DataProviderCall;
import com.programwrappers.KeywordWrappers;

public class TestCaseone {
	
	KeywordWrappers kw=new KeywordWrappers();
	
	
	@Test(dataProviderClass = DataProviderCall.class,dataProvider="fetchAll")
	public void myfirstmethod(String browser,String url,String email) throws InterruptedException {
		
		//laucch and url
		kw.launch(browser);
		kw.getURL(url);
		
		//locator(property)
		
		
	}

}
