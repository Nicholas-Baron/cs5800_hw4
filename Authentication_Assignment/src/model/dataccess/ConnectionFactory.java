package model.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {
	private final String url;
	private final String user;
	private final String pwd;

	public ConnectionFactory(String url, String user, String pwd) {
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(url, user, pwd);
	}

}
