package model.dataccess;

import model.entities.MessageException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private final String pwd;
    private final String url;
    private final String user;

    public ConnectionFactory(String url, String user, String pwd) {
        this.url = url;
        this.pwd = pwd;
        this.user = user;
    }

    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, pwd);
    }
}
