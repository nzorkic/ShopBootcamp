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
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String PRODUCTS_PAGE = "productList";
    private static final String LOGIN_PAGE = "login";

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView(LOGIN_PAGE);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView;
        User user = userService.findUserByUsername("fsafsafsafsa");
        if (PasswordUtils.verifyUserPassword("12345678", user.getPassword(), user.getSalt())) {
            modelAndView = new ModelAndView(PRODUCTS_PAGE);
            modelAndView.addObject("firstName", user.getFirstName());
            return modelAndView;
        }
        modelAndView = new ModelAndView(LOGIN_PAGE);
        modelAndView.addObject("message", "Username or Password is wrong!!");
        return modelAndView;
    }

    @GetMapping("/logout")
    public String logout() {
        return LOGIN_PAGE;
    }
}
