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

import com.msgnetconomy.shop.domain.Product;
import com.msgnetconomy.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static final String PRODUCT_PAGE = "product";

    @Autowired
    private ProductService productService;

    @GetMapping("{code}")
    public String getProductByCode(Model model, @PathVariable int code) {
        Optional<Product> product = productService.getProductByCode(code);
        product.ifPresent(productData -> model.addAttribute("product", productData));
        return PRODUCT_PAGE;
    }
}
