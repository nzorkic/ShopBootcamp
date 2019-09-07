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
import com.msgnetconomy.shop.forms.FilterForm;
import com.msgnetconomy.shop.services.CategoryService;
import com.msgnetconomy.shop.services.ProductService;
import com.msgnetconomy.shop.utils.PageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.msgnetconomy.shop.controllers.constants.ControllerConstants.Pages.PRODUCTS;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/products")
public class ProductListController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getProducts(@ModelAttribute(value = "filterForm") FilterForm filterForm,
                              @RequestParam(value = "page") Optional<Integer> pageNumber,
                              Model model) {
        Page<Product> products;
        Pageable pageRequest = PageProvider.createPageRequest(pageNumber, PageProvider.PER_PAGE_DEFAULT, filterForm);
        List<Integer> categoryCodes = filterForm.getCategories();
        if (Objects.isNull(categoryCodes)) {
            products = productService.getAllProductsForPage(pageRequest);
        } else {
            products = productService.getAllCategorizedProducts(categoryCodes, pageRequest);
        }
        model.addAttribute("pages", products.getTotalPages());
        model.addAttribute("products", products.getContent());
        model.addAttribute("categories", categoryService.getAllCategories());
        return PRODUCTS;
    }
}
