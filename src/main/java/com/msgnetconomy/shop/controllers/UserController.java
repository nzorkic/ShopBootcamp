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

import com.msgnetconomy.shop.domain.UserEntity;
import com.msgnetconomy.shop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String USER_PAGE = "user";

    @Resource
    private UserService userService;

    @GetMapping("{username}")
    public String getUser(@PathVariable String username) {
        userService.getUserByUsername(username);
        return USER_PAGE;
    }

    @PutMapping("{username}")
    public String updateUser(@RequestBody UserEntity user) {
        userService.updateUser(user);
        return USER_PAGE;
    }

}
