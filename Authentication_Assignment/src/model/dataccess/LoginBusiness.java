package model.dataccess;

import java.sql.SQLException;

import model.entities.MessageException;
import model.entities.User;

public final class LoginBusiness {

	private LoginBusiness() {
	}

	private static LoginBusiness instance;

	public static LoginBusiness getInstance() {
		if (instance == null)
			instance = new LoginBusiness();
		return instance;
	}

	public void loginUser(String userName, String password) throws MessageException {
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}

		User.getInstance().setUserName(userName);
		User.getInstance().setPassword(password);

		try {
			if (!(new LoginDataAccess().verifyCredentials(User.getInstance()))) {
				throw new MessageException("Incorrect credentials.");
			}
		} catch (ClassNotFoundException e) {
			throw new MessageException("Incorrect credentials.");
		} catch (SQLException e) {
			throw new MessageException("Incorrect credentials.");
		}
	}

}
