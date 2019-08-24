package com.msgnetconomy.shop.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cart_entry", schema = "shopdb")
public class CartEntryEntity {
    private String code;
    private double quantity;
    private String productCode;
    private String cartCode;

    @Id
    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "quantity", nullable = false, precision = 0)
    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "product_code", nullable = false, length = 45)
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "cart_code", nullable = false, length = 45)
    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntryEntity that = (CartEntryEntity) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(code, that.code) &&
                Objects.equals(productCode, that.productCode) &&
                Objects.equals(cartCode, that.cartCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, quantity, productCode, cartCode);
    }
}
