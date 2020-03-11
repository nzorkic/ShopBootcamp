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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.USER;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{username}")
    @ExceptionHandler(UserNotFoundException.class)
    public String getUser(@PathVariable String username) {
        userService.findUserByUsername(username);
        return USER;
    }

    @PostMapping("{username}/update")
    public String updateUser(@PathVariable String username,
                             @RequestParam(name = "firstName") String name) {
        User user = userService.findUserByUsername(username);
        userService.updateUser(user, name);
        return "redirect:/user/" + username;
    }
}
