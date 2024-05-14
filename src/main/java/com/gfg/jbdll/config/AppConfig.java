package com.gfg.jbdll.config;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class AppConfig {

    Log logger = LogFactory.getFactory().getInstance(AppConfig.class);

    @Value("${mysql.uri}")
    private String uri;

    @Value("${mysql.username}")
    private String username;

    @Value("${mysql.password}")
    private String password;

    @Bean("mySqlConnection")
    public Connection getMySQLConnection() {
        try{
            return DriverManager.getConnection(uri, username, password);
        } catch (SQLException e) {
            logger.error("error conneciton to mqsql.");
        }
        return null;
    }
}
