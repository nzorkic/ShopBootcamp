package com.msgnetconomy.shop.controllers;

import com.msgnetconomy.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nzorkic@netconomy.net
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("{code}")
    public String getProductByCode(@PathVariable int code, Model model) {
        model.addAttribute("product", productService.getProductByCode(code));
        return "product";
    }
}