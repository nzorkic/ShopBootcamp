package com.msgnetconomy.shop.validators;

import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class UserValidator implements Validator {

    private static final String USERNAME_EXISTS = "There is already a user registered with the username provided";
    private static final String USERNAME_SIZE = "Username must contains more than 6 characters, less than 32 characters";
    private static final String PASSWORD_SIZE = "Password must contains more than 8 characters, less than 32 characters";

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", USERNAME_SIZE);
        }

        if (Objects.nonNull(userService.findUserByUsername(user.getUsername()))) {
            errors.rejectValue("username", USERNAME_EXISTS);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", PASSWORD_SIZE);
        }

    }

}
