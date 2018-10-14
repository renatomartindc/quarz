package com.proyecto.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

public class LoggerBD implements LoggerGeneric {

	private DatabaseConnection connection;
	
	@Override
	public void generateLog(String message, Logger log, Map dbParamsMap,
			char logLevel) {
		int    t = 0;
		String l = null;
		t =  logLevel=='M'?1:logLevel=='E'?2:3;
		l += logLevel=='M'?"message ":logLevel=='E'?"error ":"warning ";
		l += DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + message;
	    
		try {
			connection.getInstance(dbParamsMap).getConnection().createStatement().executeUpdate("insert into Log_Values('" + l + "', " + String.valueOf(t) + ")");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}
