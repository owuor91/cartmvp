package io.github.owuor91.cartmvp;

import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import io.github.owuor91.cartmvp.model.LineItem;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class ShoppingCart {
    private final SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private List<LineItem> shoppingCart;

    private static final String OPEN_CART_EXISTS = "open_cart_exists";
    private static final String SERIALIZED_CART_ITEMS = "serialized_cart_items";
    private static final String SERIALIZED_CUSTOMER = "serialized_customer";

    public ShoppingCart(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        editor = sharedPreferences.edit();
        initShoppingCart();
    }

    private void initShoppingCart(){
        shoppingCart = new ArrayList<>();

        Gson gson = new Gson();

        if(sharedPreferences.getBoolean(OPEN_CART_EXISTS, false)){
            String serializedCartItems = sharedPreferences.getString(SERIALIZED_CART_ITEMS, "");
            String serializedCustomer = sharedPreferences.getString(SERIALIZED_CUSTOMER, "");
            if (!serializedCartItems.equals("")){
                shoppingCart = gson.<ArrayList<LineItem>>fromJson(serializedCartItems, new TypeToken<ArrayList<LineItem>>(){}.getType());
            }
        }
    }


    public void addItemToCart(LineItem lineItem){
        if (shoppingCart.contains(lineItem)){
            int currentPosition = shoppingCart.indexOf(lineItem);
            LineItem itemAlreadyInCart = shoppingCart.get(currentPosition);
            itemAlreadyInCart.setQuantity(itemAlreadyInCart.getQuantity() + lineItem.getQuantity());
            shoppingCart.set(currentPosition, itemAlreadyInCart);
        }
        else {
            shoppingCart.add(lineItem);
        }
    }


    public void clearShoppingCart(){
        shoppingCart.clear();
        editor.putString(SERIALIZED_CART_ITEMS, "").commit();
        editor.putString(SERIALIZED_CUSTOMER, "").commit();
        editor.putBoolean(OPEN_CART_EXISTS, false).commit();
    }


    public void removeItemFromCart(LineItem lineItem){
        shoppingCart.remove(lineItem);
    }


    public void completeCheckout(){
        shoppingCart.clear();
    }


    public List<LineItem> getShoppingCart(){
        return shoppingCart;
    }


    public void saveCartToPreference(){
        if (shoppingCart !=null){
            Gson gson = new Gson();
            String serializedItems = gson.toJson(shoppingCart);
            editor.putString(SERIALIZED_CART_ITEMS, serializedItems).commit();
            editor.putBoolean(OPEN_CART_EXISTS, true).commit();
        }
    }


    public void updateItemQuantity(LineItem lineItem, int quantity){
        boolean itemAlreadyInCart = shoppingCart.contains(lineItem);
        if (itemAlreadyInCart){
            int position = shoppingCart.indexOf(lineItem);
            LineItem itemInCart = shoppingCart.get(position);
            itemInCart.setQuantity(quantity);
            shoppingCart.set(position,itemInCart);
        }
        else {
            lineItem.setQuantity(quantity);
            shoppingCart.add(lineItem);
        }
    }
}
