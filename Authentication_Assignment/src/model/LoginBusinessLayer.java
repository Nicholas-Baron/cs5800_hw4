package model;

import model.dataccess.LoginDataAccess;
import model.entities.MessageException;
import model.entities.User;

import java.sql.SQLException;

public class LoginBusinessLayer {

    private static LoginBusinessLayer instance = null;
    private final LoginDataAccess loginDataAccess;

    public static LoginBusinessLayer getInstance() {
        if (instance == null) {
            instance = new LoginBusinessLayer(new LoginDataAccess());
        }
        return instance;
    }

    private LoginBusinessLayer(LoginDataAccess dataAccess) {
        this.loginDataAccess = dataAccess;
    }

    public void loginUser(String userName, String password)
        throws SQLException, ClassNotFoundException {

        if (userName.equals("")) {
            throw new MessageException("Username not informed.");
        } else if (password.equals("")) {
            throw new MessageException("Password not informed.");
        }

        User user = new User(userName, password);

        if (!loginDataAccess.verifyCredentials(user)) {
            throw new MessageException("Incorrect credentials.");
        }
    }

}
