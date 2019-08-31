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
import com.msgnetconomy.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final String REGISTERED_SUCCESSFULLY = "User has been registered successfully";
    private static final String LOGIN_PAGE = "login";
    private static final String REGISTRATION_PAGE = "registration";

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping
    public ModelAndView register(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName(REGISTRATION_PAGE);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView register(@ModelAttribute("user") User user, BindingResult bindingResult, ModelAndView modelAndView) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName(REGISTRATION_PAGE);
            return modelAndView;
        }
        userService.saveUser(user);
        modelAndView.addObject("successMessage", REGISTERED_SUCCESSFULLY);
        modelAndView.addObject("user", user);
        modelAndView.setViewName(LOGIN_PAGE);
        return modelAndView;
    }

}
