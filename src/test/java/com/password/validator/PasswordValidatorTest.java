package com.password.validator;

import static org.junit.Assert.*;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PasswordValidator.class})
public class PasswordValidatorTest {

	@Autowired 
	PasswordValidator passwordValidator;
	@Test
	public void testValidate() {
		String password ="milesajay1";
		passwordValidator.validate(password);
	}

	@Test
	public void testCheckSequenceRepetition() {
		String password ="milesmiles";
		passwordValidator.validate(password);
	}

	@Test
	public void testCheckLetterAndDigit() {
		String password ="milesajay";
		passwordValidator.validate(password);
	}

	@Test
	public void testCheckCase() {
		String password ="MILESAJAY1";
		passwordValidator.validate(password);
	}

	@Test
	public void testCheckLengthValid() {
		String password ="1234";
		passwordValidator.validate(password);
	}
	
	@Test
	public void testCheckLengthInValid() {
		String password ="milesjay1";
		passwordValidator.validate(password);
	}

}
