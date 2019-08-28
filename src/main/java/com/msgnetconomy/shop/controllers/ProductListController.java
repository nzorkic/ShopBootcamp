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
import com.msgnetconomy.shop.services.CategoryService;
import com.msgnetconomy.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/products")
public class ProductListController {

    private static final String PRODUCT_LIST_PAGE = "productList";

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String products(@RequestParam(value = "categories", required = false) List<Integer> categoryCodes, Model model) {
        populateModelWithProducts(categoryCodes, model);
        model.addAttribute("categories", categoryService.getAllCategories());
        return PRODUCT_LIST_PAGE;
    }

    private void populateModelWithProducts(List<Integer> categoryCodes, Model model) {
        List<Product> products;
        if (CollectionUtils.isEmpty(categoryCodes)) {
            products = productService.getAllProducts();
        } else {
            products = productService.getAllProductsForCategories(categoryCodes);
        }
        model.addAttribute("products", products);
    }
}
