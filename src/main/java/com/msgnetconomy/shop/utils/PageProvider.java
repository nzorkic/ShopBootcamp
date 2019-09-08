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

package com.msgnetconomy.shop.utils;

import com.msgnetconomy.shop.forms.FilterForm;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author nzorkic@netconomy.net
 */
public class PageProvider {

    public static final int PER_PAGE_DEFAULT = 12;

    private static final int INITIAL_PAGE = 0;
    private static final String ASC = "ASC";
    private static final String NAME = "name";
    private static final String DESC = "DESC";
    private static final String PRICE = "price";

    private static Pageable createPageRequest(int page, int perPage, FilterForm filterForm) {
        if (filterForm.isEmpty()) {
            return PageRequest.of(page, perPage);
        }
        List<Order> orders = getSortingOrders(filterForm);
        return PageRequest.of(page, perPage, Sort.by(orders));
    }

    public static Pageable createPageRequest(Optional<Integer> page, Integer perPage, FilterForm filterForm) {
        int currentPage = page.orElse(0) < 1 ? INITIAL_PAGE : page.get() - 1;
        int productsFerPage = perPage == null ? PER_PAGE_DEFAULT : perPage;
        return createPageRequest(currentPage, productsFerPage, filterForm);
    }

    private static List<Order> getSortingOrders(FilterForm filterForm) {
        List<Order> orders = new ArrayList<>();
        if (ASC.equals(filterForm.getNameSort())) {
            orders.add(Order.asc(NAME));
        } else if (DESC.equals(filterForm.getNameSort())) {
            orders.add(Order.desc(NAME));
        }
        if (ASC.equals(filterForm.getPriceSort())) {
            orders.add(Order.asc(PRICE));
        } else if (DESC.equals(filterForm.getPriceSort())) {
            orders.add(Order.desc(PRICE));
        }
        return orders;
    }
}
