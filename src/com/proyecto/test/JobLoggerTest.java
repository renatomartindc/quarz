package com.proyecto.test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Test;

public class JobLoggerTest {

	@Test
	public void getMessage(){
		Map m = new HashMap();
		Logger logger = Logger.getLogger("MyLog");
		LoggerGeneric loggerTest = JobLoggerFactory.getLogger('C');
		
		try{
			loggerTest.generateLog("Testeando....message", logger, m, 'M');
		}catch(Exception ex){
			try {
				loggerTest.generateLog("Testeando....message", logger, m, 'E');
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
