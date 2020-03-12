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

package com.msgnetconomy.shop.repository;

import com.msgnetconomy.shop.domain.Cart;
import com.msgnetconomy.shop.domain.CartEntry;
import com.msgnetconomy.shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author nzorkic@netconomy.net
 */
public interface CartEntryRepository extends JpaRepository<CartEntry, Integer> {

    @Query("SELECT ce FROM CartEntry ce WHERE ce.cart = ?1")
    List<CartEntry> findAllByCart(Cart cart);

    @Query("SELECT ce FROM CartEntry ce WHERE ce.cart = ?1 AND ce.product = ?2")
    Optional<CartEntry> entryExistsInCart(Cart cart, Product product);
}
