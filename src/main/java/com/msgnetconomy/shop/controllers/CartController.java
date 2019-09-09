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

import com.msgnetconomy.shop.domain.Cart;
import com.msgnetconomy.shop.domain.CartEntry;
import com.msgnetconomy.shop.domain.Product;
import com.msgnetconomy.shop.services.CartService;
import com.msgnetconomy.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.CART;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.ORDER;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.REDIRECT_PREFIX;
import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.SLASH;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    private static final String CART_PAGE = SLASH + CART;
    private static final String ORDER_PAGE = SLASH + ORDER;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getCart(Model model, HttpServletRequest request) {
        List<CartEntry> cartItems = cartService.getCartEntries(request);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", cartService.calculateTotal(cartItems));
        return CART;
    }

    @PostMapping("add/{code}")
    public String addToCart(@PathVariable Integer code, HttpServletRequest request) {
        Cart cart = cartService.getCartForUser(request);
        Product productForCart = productService.getProductByCode(code);
        if (cartService.entryExistsInCart(cart, productForCart)) {
            cartService.updateQuantity(cart, productForCart);
        } else {
            cartService.createCartEntry(cart, productForCart);
        }
        return REDIRECT_PREFIX + request.getHeader("referer");
    }

    @PostMapping("remove/{entryCode}")
    public String removeFromCart(@PathVariable Integer entryCode) {
        cartService.removeFromCart(entryCode);
        return REDIRECT_PREFIX + CART_PAGE;
    }

    @PostMapping("/purchase")
    public String makeOrder(HttpServletRequest request) {
        cartService.removeOrdersFromCart(cartService.getCartEntries(request));
        return REDIRECT_PREFIX + ORDER_PAGE;
    }
}
