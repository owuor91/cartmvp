package io.github.owuor91.cartmvp;

import javax.inject.Inject;

import io.github.owuor91.cartmvp.model.LineItem;
import io.github.owuor91.cartmvp.model.Product;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class ProductPresenter {
    @Inject ShoppingCart shoppingCart;

    public ProductPresenter(){
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    public void onItemQuanityChanged(LineItem lineItem, int quantity){
        shoppingCart.updateItemQuantity(lineItem, quantity);
    }

    public void onAddToCartButtonClicked(Product product){
        LineItem lineItem = new LineItem(product, 1);
        shoppingCart.addItemToCart(lineItem);
    }

    public void onClearButtonClicked(){
        shoppingCart.clearShoppingCart();
    }


    public void onDeleteItemButtonClicked(LineItem lineItem){
        shoppingCart.removeItemFromCart(lineItem);
    }
}
