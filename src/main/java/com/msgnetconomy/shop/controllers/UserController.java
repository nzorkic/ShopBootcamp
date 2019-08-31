/*********************************************************************
 * The Initial Developer of the content of this file is NETCONOMY.
 * All portions of the code written by NETCONOMY are property of
 * NETCONOMY. All Rights Reserved.
 *
 * NETCONOMY Software & Consulting GmbH
 * Hilmgasse 4, A-8010 Graz (Austria)
 * FN 204360 f, Landesgericht fuer ZRS Graz
 * Tel: +43 (316) 815 544
 * Fax: +43 (316) 815544-99
 * www.netconomy.net
 *
 * (c) 2019 by NETCONOMY Software & Consulting GmbH
 *********************************************************************/

package com.msgnetconomy.shop.controllers;

import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.exceptions.UserNotFoundException;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String USER_PAGE = "user";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("{username}")
    @ExceptionHandler(UserNotFoundException.class)
    public String getUser(@PathVariable String username) {
        userService.findUserByUsername(username);
        return USER_PAGE;
    }

    @PutMapping("{uid}")
    public String updateUser(@RequestBody User user, @PathVariable Long uid, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new UserNotFoundException(uid);
        }
        userService.updateUser(user, uid);
        return USER_PAGE;
    }

}
