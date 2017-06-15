package io.github.owuor91.cartmvp.model;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class Product {
    private long id;
    private String productName;
    private String description;
    private double salePrice;

    public Product() {
    }

    public Product(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.salePrice = product.getSalePrice();
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getSalePrice() {
        return salePrice;
    }
}
