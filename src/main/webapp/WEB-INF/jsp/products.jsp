<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link href="/css/productList.css" rel="stylesheet"/>
</head>
<body>

<div class="container">
    <div class="starter-template">
        <h1>Categories:</h1>
        <c:forEach items="${categories}" var="category">
            <p>${category.name}</p>
        </c:forEach>
        <h1>Products:</h1>
        <div class="container">
            <div id="products" class="row">
                <c:forEach items="${products}" var="product">
                    <div class="item  col-xs-4 col-lg-4">
                        <div class="thumbnail">
                            <img class="group list-group-image" src="/images/products/${product.image}" alt=""/>
                            <div class="caption">
                                <h4 class="group inner list-group-item-heading">${product.name} | ${product.category.name}</h4>
                                <p class="group inner list-group-item-text">${product.description}</p>
                                <div class="row">
                                    <div class="col-xs-12 col-md-6">
                                        <p class="lead">${product.price}</p>
                                    </div>
                                    <div class="col-xs-12 col-md-6">
                                        <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="page-container middle">
            <div class="pagination">
                <ul>
                    <li><a href="#"></a></li>
                    <c:forEach begin="1" end="${pages}" varStatus="loop">
                        <li><a href="/products/page/${loop.index}"></a></li>
                    </c:forEach>
                    <li><a href="#"></a></li>
                </ul>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/home.js"></script>

</body>

</html>
