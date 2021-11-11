package model.dataccess;

import java.sql.SQLException;

import model.entities.MessageException;
import model.entities.User;

public final class LoginBusiness {

	public User loginUser(String userName, String password) throws MessageException {
		if (userName.equals("")) {
			throw new MessageException("Username not informed.");
		} else if (password.equals("")) {
			throw new MessageException("Password not informed.");
		}

		User user = new User(userName, password);

		try {
			if (!(new LoginDataAccess().verifyCredentials(user))) {
				throw new MessageException("Incorrect credentials.");
			}
		} catch (ClassNotFoundException e) {
			throw new MessageException("Incorrect credentials.");
		} catch (SQLException e) {
			throw new MessageException("Incorrect credentials.");
		}
		return user;
	}

}
