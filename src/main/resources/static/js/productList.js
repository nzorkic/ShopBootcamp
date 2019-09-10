$(document).ready(function () {
    var categoryList = getUrlCategoryParameter('categories');
    var nameSort     = getUrlParameter('nameSort');
    var priceSort    = getUrlParameter('priceSort');
    var page         = getUrlParameter('page');

    $.each(categoryList, function (index, value) {
        $(':checkbox[value=' + value + ']').prop('checked', 'true');
    });

    if (nameSort !== undefined) {
        $('select[name=\'nameSort\'] option[value=' + nameSort + ']').attr('selected', 'selected');
    }

    if (priceSort !== undefined) {
        $('select[name=\'priceSort\'] option[value=' + priceSort + ']').attr('selected', 'selected');
    }
});

var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL      = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};

var getUrlCategoryParameter = function getUrlCategoryParameter(sParam) {
    var sPageURL      = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    var result = [];

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            result.push(decodeURIComponent(sParameterName[1]));
        }
    }

    return result;
};

function addToCart(path) {
    $.post(path);
    alert('Product added to the cart.');
}