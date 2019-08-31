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
import com.msgnetconomy.shop.utils.PageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/products")
public class ProductListController {

    private static final String PRODUCT_LIST_PAGE = "productList";
    private static final String CATEGORIES = "categories";

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getProducts(@RequestParam(value = "categories", required = false) List<Integer> categoryCodes,
                              Model model) {
        Pageable pareRequest = PageProvider.createPageRequest(PageProvider.INITIAL_PAGE, PageProvider.PER_PAGE_DEFAULT);
        populateModelWithProducts(categoryCodes, model, pareRequest);
        model.addAttribute(CATEGORIES, categoryService.getAllCategories());
        return PRODUCT_LIST_PAGE;
    }

    @GetMapping(path = "/page/{pageNumber}")
    public String getProductsForPage(@RequestParam(value = "categories", required = false) List<Integer> categoryCodes,
                                     @PathVariable(value = "pageNumber") Optional<Integer> pageNumber,
                                     Model model) {
        Pageable pareRequest = PageProvider.createPageRequest(pageNumber, PageProvider.PER_PAGE_DEFAULT);
        populateModelWithProducts(categoryCodes, model, pareRequest);
        model.addAttribute(CATEGORIES, categoryService.getAllCategories());
        return PRODUCT_LIST_PAGE;
    }

    private void populateModelWithProducts(List<Integer> categoryCodes, Model model, Pageable pareRequest) {
        Page<Product> products;
        if (CollectionUtils.isEmpty(categoryCodes)) {
            products = productService.getAllProductsForPage(pareRequest);
        } else {
            products = productService.getAllProductsForPageByCategories(categoryCodes, pareRequest);
        }
        model.addAttribute("pages", products.getTotalPages());
        model.addAttribute("products", products.getContent());
    }
}
