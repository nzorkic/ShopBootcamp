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
import com.msgnetconomy.shop.utils.ErrorUtils;
import com.msgnetconomy.shop.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private UserService userService;

    @GetMapping
    public String showLogin(@RequestParam(value = "errorMessage", required = false) String errorMessage, Model model) {
        model.addAttribute("errorMessage", errorMessage);
        return LOGIN;
    }

    @PostMapping
    public String login(@ModelAttribute LoginForm loginForm, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        User user = userService.findUserByUsername(loginForm.getUsername());

        if (Objects.isNull(user)) {
            return ErrorUtils.createMessageAndRedirect(redirectAttributes, LOGIN, "User does not exist.");
        }

        boolean userVerified = PasswordUtils.verifyUserPassword(loginForm.getPassword(), user.getPassword(), user.getSalt());

        if (!userVerified) {
            return ErrorUtils.createMessageAndRedirect(redirectAttributes, LOGIN, "Wrong password.");
        }

        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", user);
        return REDIRECT_PREFIX + PRODUCTS_PAGE;
    }
}
