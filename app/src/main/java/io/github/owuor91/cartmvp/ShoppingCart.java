package io.github.owuor91.cartmvp;

import android.content.SharedPreferences;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class ShoppingCart {
    private final SharedPreferences sharedPreferences;

    public ShoppingCart(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
