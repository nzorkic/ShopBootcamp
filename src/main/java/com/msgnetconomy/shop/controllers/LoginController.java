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
import com.msgnetconomy.shop.forms.LoginForm;
import com.msgnetconomy.shop.services.UserService;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.LOGIN;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.PRODUCTS;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.REDIRECT_PREFIX;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.SLASH;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String PRODUCTS_PAGE = SLASH + PRODUCTS;
    private static final String LOGIN_PAGE = SLASH + LOGIN;
    private static final String LOGIN_PAGE_REDIRECT = REDIRECT_PREFIX + LOGIN_PAGE;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLogin() {
        return LOGIN;
    }

    @PostMapping
    public String login(@ModelAttribute LoginForm loginForm, Model model, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.findUserByUsername(loginForm.getUsername());
        boolean userVerified = PasswordUtils.verifyUserPassword(loginForm.getPassword(), user.getPassword(), user.getSalt());
        if (!userVerified) {
            model.addAttribute("errorMessage", "Username or Password is wrong!!");
            return LOGIN_PAGE_REDIRECT;
        }
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", user);
        return REDIRECT_PREFIX + PRODUCTS_PAGE;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return LOGIN_PAGE_REDIRECT;
    }
}
