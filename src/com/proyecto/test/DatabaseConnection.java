package com.proyecto.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection(Map dbParams) throws SQLException {
        Properties connectionProps = new Properties();
		connectionProps.put("user", dbParams.get("userName"));
		connectionProps.put("password", dbParams.get("password"));
		this.connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName") + ":" + dbParams.get("portNumber") + "/", connectionProps);
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance(Map dbParamsMap) throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection(dbParamsMap);
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection(dbParamsMap);
        }

        return instance;
    }
}
