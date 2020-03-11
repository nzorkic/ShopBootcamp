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

package com.msgnetconomy.shop.services;

import com.msgnetconomy.shop.domain.Cart;
import com.msgnetconomy.shop.domain.CartEntry;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nzorkic@netconomy.net
 */
public interface CartService {

    Cart createCart();

    List<CartEntry> getCartEntries(HttpServletRequest request);

    void removeFromCart(int entryCode);

    double calculateTotal(List<CartEntry> cartEntries);

    void removeOrdersFromCart(List<CartEntry> entries);
}
