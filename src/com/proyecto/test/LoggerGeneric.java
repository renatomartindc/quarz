package com.proyecto.test;

import java.util.Map;
import java.util.logging.Logger;

public interface LoggerGeneric {
	
	public void generateLog(String message,Logger log,Map dbParamsMap,char logLevelParam);

}
