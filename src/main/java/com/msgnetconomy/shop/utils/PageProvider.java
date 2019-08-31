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

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author nzorkic@netconomy.net
 */
public class PageProvider {

    private static final int PER_PAGE_DEFAULT = 10;
    private static final int INITIAL_PAGE = 0;

    public static Pageable createPageRequest(Optional<Integer> page, Integer perPage) {
        int currentPage = page.orElse(0) < 1 ? INITIAL_PAGE : page.get() - 1;
        int productsFerPage = perPage == null ? PER_PAGE_DEFAULT : perPage;
        return PageRequest.of(currentPage, productsFerPage);
    }
}
