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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final String REGISTERED_SUCCESSFULLY = "User has been registered successfully";
    private static final String USERNAME_EXISTS = "There is already a user registered with the username provided";
    private static final String LOGIN_PAGE = "login";
    private static final String REGISTRATION_PAGE = "registration";

    @Resource
    private UserService userService;

    @GetMapping
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        UserEntity user = new UserEntity();
        modelAndView.addObject("user", user);
        modelAndView.setViewName(REGISTRATION_PAGE);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView register(@Valid UserEntity user, BindingResult bindingResult) {
        if (userService.findByUsername(user).isPresent()) {
            bindingResult.rejectValue("username", "error.user",
                    USERNAME_EXISTS);
        }
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(REGISTRATION_PAGE);
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", REGISTERED_SUCCESSFULLY);
            modelAndView.addObject("user", new UserEntity());
            modelAndView.setViewName(LOGIN_PAGE);
        }
        return modelAndView;
    }

}
