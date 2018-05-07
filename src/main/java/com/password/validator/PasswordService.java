package com.password.validator;



import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Creates RESTful operations for the Password Validator resource.
 * 
 */
@RestController
@RequestMapping(value = "/password")
public class PasswordService {

	/** Logger. */
	private static Logger LOGGER = LoggerFactory.getLogger(PasswordService.class);
	@Autowired
	private PasswordValidator passwordValidator;

	@RequestMapping(value= "/validatePassword",method = RequestMethod.GET)
	public Set<String> validatePassword(@RequestParam("password") String password) {
		if (LOGGER.isTraceEnabled()) {
			LOGGER.trace("Inside Rest call validatePassword :");
		}
		LOGGER.debug("Entering Rest activatePort :");
		Set<String> response = null;
		try {
			response = passwordValidator.validate(password);
		} catch (Exception e) {
			LOGGER.error("Error in validatePassword", e);
			
		}
		LOGGER.debug("Exiting Rest call validatePassword :");
		return response;
	}
	
}
