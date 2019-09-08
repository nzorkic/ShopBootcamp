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

package com.msgnetconomy.shop.utils;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.REDIRECT_PREFIX;

/**
 * @author nzorkic@netconomy.net
 */
public class ErrorUtils {

    public static String createMessageAndRedirect(RedirectAttributes redirectAttributes, String redirectPage, String message) {
        redirectAttributes.addAttribute("errorMessage", message);
        return REDIRECT_PREFIX + redirectPage;
    }

    public static String getErrorMessage(BindingResult bindingResult) {
        ArrayList<String> errors =
            new ArrayList<>(Arrays.asList(Objects.requireNonNull(bindingResult.getAllErrors()
                                                                              .get(bindingResult.getErrorCount() - 1)
                                                                              .getCodes())));

        return errors.get(errors.size() - 1);
    }
}
