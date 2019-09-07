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

import com.msgnetconomy.shop.domain.Product;
import com.msgnetconomy.shop.forms.FilterForm;
import com.msgnetconomy.shop.repository.ProductRepository;
import com.msgnetconomy.shop.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nzorkic@netconomy.net
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> getAllProductsForPage(Pageable pareRequest) {
        return productRepository.findAll(pareRequest);
    }

    @Override
    public Product getProductByCode(int code) {
        return productRepository.getOne(code);
    }

    @Override
    public Page<Product> getAllCategorizedProducts(List<Integer> categoryCodes, Pageable pareRequest) {
        return productRepository.findAllForCategories(categoryCodes, pareRequest);
    }
}
