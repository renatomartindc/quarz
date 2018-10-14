package com.proyecto.test;

public class JobLoggerFactory {

	public static LoggerGeneric getLogger(char c){
		if(c=='F')
			return new LoggerFile();
		else if (c=='C')
			return new LoggerConsole();
		else if (c=='D')
			return new LoggerBD();
		
		return null;
		
	}
}
