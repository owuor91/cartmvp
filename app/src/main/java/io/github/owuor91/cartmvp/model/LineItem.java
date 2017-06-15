package io.github.owuor91.cartmvp.model;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class LineItem extends Product{
    private int quantity;

    public LineItem(){}

    public LineItem(Product product, int quantity) {
        super(product);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumPrice(){
        return getSalePrice()*quantity;
    }
}
