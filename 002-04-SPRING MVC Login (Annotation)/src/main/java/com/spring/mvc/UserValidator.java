package com.spring.mvc;

import org.apache.log4j.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
	final static Logger LOGGER = Logger.getLogger(UserValidator.class);

	public boolean supports(Class clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object command, Errors errors) {
		User user = (User) command;
		if (user.getUsername() == null || user.getUsername().length() == 0) {
			LOGGER.debug("Username Required");
			errors.rejectValue("username", "errors.username.required", null,
					"Username Required");

		}

		if (user.getPassword() == null || user.getPassword().length() == 0) {
			LOGGER.debug("Password Required");
			errors.rejectValue("password", "errors.password.required", null,
					"Password Required");

		}
	}
}
