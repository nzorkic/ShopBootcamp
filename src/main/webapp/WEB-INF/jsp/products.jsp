<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">

<head>
    <link href="/css/main.css" rel="stylesheet"/>
    <link href="/css/productList.css" rel="stylesheet"/>
</head>

<body>
<jsp:include page="common/header.jsp"/>
<div class="content">
    <form:form method="get" modelAttribute="filterForm" action="products">
        <div class="product__container">
            <aside class="product__filter">
                <h1 class="heading--bold">Categories:</h1>
                <c:forEach items="${categories}" var="category">
                    <div class="form__item">
                        <input type="checkbox" name="categories" value="${category.code}" id="${category.name}">
                        <label for="${category.name}" class="product__filter-item">${category.name}</label>
                    </div>
                </c:forEach>
                <select name="nameSort">
                    <option value="" selected disabled>Name...</option>
                    <option value="ASC">Ascending</option>
                    <option value="DESC">Descending</option>
                </select>
                <select name="priceSort">
                    <option value="" selected disabled>Price...</option>
                    <option value="ASC">Ascending</option>
                    <option value="DESC">Descending</option>
                </select>
                <input type="submit" value="Filter">
            </aside>
            <section class="product__list">
                <h1>Products:</h1>
                <div id="products">
                    <c:forEach items="${products}" var="product">
                        <div class="product">
                            <a href="/product/${product.code}"><img class="product__image"
                                 src="<%=request.getContextPath()%>/images/products/${product.image}" alt=""/>
                            </a>
                            <div class="product__details">
                                <h3 class="product__details-name">${product.name} | ${product.category.name}
                                    <p class="product__details-description">${product.description}</p>
                                    <p class="product__details-price">
                                            ${product.price}
                                    </p>
                                    <p class="product__details-button">
                                        <button class="product__details-button--confirm button button--cta"
                                                type="button">Add to cart
                                        </button>
                                    </p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </div>
        <div class="page-container middle">
            <div class="pagination">
                <c:forEach begin="1" end="${pages}" varStatus="loop">
                    <button name="page" value="${loop.index}" type="submit">Page ${loop.index}</button>
                </c:forEach>
            </div>
        </div>
    </form:form>
</div>
<jsp:include page="common/footer.jsp"/>

<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/home.js"></script>
<script type="text/javascript" src="/js/priductList.js"></script>

</body>

</html>