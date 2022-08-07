package org.baseclass.com;

public class CommonUtils_Input extends CommonUtils{
	
	public static void execution() {
		browserLaunch("chrome");
		openUrl("https://adactinhotelapp.com/");
		fullscreenView();
		typeValue(FindingElement(locatebyId("username")), "javeed");
		typeValue(FindingElement(locatebyId("password")), "aaqib");	
		browserClose();
	}
}	
