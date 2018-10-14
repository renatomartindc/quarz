package com.proyecto.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerFile implements LoggerGeneric{

	@Override
	public void generateLog(String message, Logger logger, Map dbParams,
			char logLevelParam) {
		File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt");
		if (!logFile.exists()) {
		  try {
			logFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		FileHandler fh = null;
		try {
			fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.addHandler(fh);
		logger.log(Level.INFO, message);
		
	}

}
