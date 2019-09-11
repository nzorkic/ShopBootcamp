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
import com.msgnetconomy.shop.services.CartService;
import com.msgnetconomy.shop.utils.ErrorUtils;
import com.msgnetconomy.shop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.LOGIN;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.REGISTRATION;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.REDIRECT_PREFIX;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.SLASH;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private static final String REGISTERED_SUCCESSFULLY = "User has been registered successfully!";
    private static final String REGISTRATION_PAGE = SLASH + REGISTRATION;
    private static final String LOGIN_PAGE = SLASH + LOGIN;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserValidator userValidator;

    // TODO TASK 1: Create method for registration GET request

    @PostMapping
    public String register(@ModelAttribute("user") User user,
                           BindingResult bindingResult,
                           Model model,
                           RedirectAttributes redirectAttributes) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            redirectAttributes.addAttribute("errorMessage", ErrorUtils.getErrorMessage(bindingResult));
            return REDIRECT_PREFIX + REGISTRATION_PAGE;
        }
        user.setImage("user_placeholder.png");
        user.setCart(cartService.createCart());
        // TODO TASK 2: Call user service to save user
        model.addAttribute("successMessage", REGISTERED_SUCCESSFULLY);
        model.addAttribute("user", user);
        return REDIRECT_PREFIX + LOGIN_PAGE;
    }

}
