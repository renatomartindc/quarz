package com.proyecto.test;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerConsole implements LoggerGeneric{

	@Override
	public void generateLog(String message, Logger logger, Map dbParamsMap,
			char logLevelParam) {
		ConsoleHandler ch = new ConsoleHandler();
		logger.addHandler(ch);
		logger.log(Level.INFO, message);
		
	}
}
