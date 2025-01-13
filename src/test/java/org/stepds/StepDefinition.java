package org.stepds;

import org.utils.BaseClass;

public class StepDefinition extends BaseClass{
	
	public static void main(String[] args) {
		
		browserLaunch("chrome");
		urllaunch("http://www.facebook.com");
		maximize();
		implicitlyWait(20);
		
		
		
	}

}
