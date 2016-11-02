package com.spring.mvc;

import java.util.Map;

import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes
public class LoginController {
	final static Logger LOGGER = Logger.getLogger(LoginController.class);
	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/verifyUser", method = RequestMethod.POST)
	public String verifyUser(@ModelAttribute("user") User user,
			BindingResult result) {
		LOGGER.debug("verifyUser() method called");
		System.out.println("inside verifyUser() method");
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			return "login";
		}

		// User user=(User)command;
		String un = user.getUsername();
		String pw = user.getPassword();
		System.out.println(un);
		System.out.println(pw);
		LOGGER.info("username: " + un + "  Password: " + pw);
		if (!un.equals(pw)) {
			return "login";
		}
		return "home";
	}

	@RequestMapping(value = "/login")
	public String showLoginForm(Map model) throws ServletException {
		LOGGER.debug("showLoginForm() method called");
		System.out.println("inside showLoginForm() method");
		User user = new User();
		user.setUsername("manjit");
		model.put("user", user);
		return "login";
	}

}
