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

package com.msgnetconomy.shop.services.impl;

import com.msgnetconomy.shop.domain.Cart;
import com.msgnetconomy.shop.domain.CartEntry;
import com.msgnetconomy.shop.domain.Product;
import com.msgnetconomy.shop.domain.User;
import com.msgnetconomy.shop.repository.CartEntryRepository;
import com.msgnetconomy.shop.repository.CartRepository;
import com.msgnetconomy.shop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nzorkic@netconomy.net
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartEntryRepository cartEntryRepository;

    @Override
    public Cart createCart() {
        return cartRepository.save(new Cart());
    }

    @Override
    public Cart getCartForUser(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        return user.getCart();
    }

    @Override
    public boolean entryExistsInCart(Cart cart, Product product) {
        return cartEntryRepository.entryExistsInCart(cart, product).isPresent();
    }

    @Override
    public void updateQuantity(Cart cart, Product product) {
        cartEntryRepository.updateQuantityForProduct(product);
    }

    @Override
    public void createCartEntry(Cart cart, Product product) {
        CartEntry cartEntry = new CartEntry();
        cartEntry.setCart(cart);
        cartEntry.setProduct(product);
        cartEntry.setQuantity(1);
        cartEntryRepository.save(cartEntry);
    }

    @Override
    public void removeFromCart(int entryCode) {
        cartEntryRepository.deleteById(entryCode);
    }

    @Override
    public double calculateTotal(List<CartEntry> cartEntries) {
        return cartEntries.stream().mapToDouble(entry -> entry.getQuantity() * entry.getProduct().getPrice()).sum();
    }

}
