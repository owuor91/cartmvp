package io.github.owuor91.cartmvp.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.owuor91.cartmvp.ShoppingCart;

/**
 * Created by johnowuor on 15/06/2017.
 */
@Module
public class ShoppingCartModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    @Provides
    @Singleton
    ShoppingCart providesShoppingCart(SharedPreferences sharedPreferences){
        return new ShoppingCart(sharedPreferences);
    }
}
