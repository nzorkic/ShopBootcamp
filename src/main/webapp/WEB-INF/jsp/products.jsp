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
    <jsp:include page="common/header.jsp" />
    <div class="content">
        <form:form method="get" modelAttribute="filterForm" action="products">
        <div class="products-wrapper">
            <div class="product__filter">
                <h3>Search preferences</h3>
                <hr>
                <h4>Category</h4>
                <c:forEach items="${categories}" var="category">
                    <div class="form__item">
                        <input type="checkbox" name="categories" value="${category.code}" id="${category.name}">
                        <label for="${category.name}">${category.name}</label>
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
            </div>
            <div class="product-list">
                <div id="products">
                    <c:forEach items="${products}" var="product">
                        <div class="product">
                            <img class="product__sale" src="<%=request.getContextPath()%>/images/sale.png"
                            alt="sale logo">

                            <a href="/product/${product.code}">
                                <img class="product__image"
                                 src="<%=request.getContextPath()%>/images/products/${product.image}" alt="Product image" />
                            </a>
                            <div class="product__details">
                                <h3>${product.name} | ${product.category.name}</h3>
                                <p class="product__details-description">${product.description}</p>
                                <p class="product__details-price">${product.price}</p>
                                <button class="product__details-button" type="button">Add to cart</button>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
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