package model.dataccess;

import model.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDataAccess {

    private static final String URL = "jdbc:postgresql://localhost:5432/authentication";
    private static final String USER = "postgres";
    private static final String PWD = "123";

    private static final ConnectionFactory connectionFactory = new ConnectionFactory(
        URL, USER, PWD
    );

    public Boolean verifyCredentials(User user) throws SQLException, ClassNotFoundException {

        Connection connection = connectionFactory.makeConnection();

        final PreparedStatement stmt = connection.prepareStatement(
            "SELECT * FROM users WHERE username=? and password=?");

        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getPassword());

        ResultSet rs = stmt.executeQuery();

        return rs.next();

    }

}

