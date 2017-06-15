package io.github.owuor91.cartmvp;

import android.app.Application;

import io.github.owuor91.cartmvp.components.AppComponent;
import io.github.owuor91.cartmvp.components.DaggerAppComponent;
import io.github.owuor91.cartmvp.modules.AppModule;

/**
 * Created by johnowuor on 15/06/2017.
 */

public class ProntoShopApplication extends Application {
    private static ProntoShopApplication instance = new ProntoShopApplication();
    private static AppComponent appComponent;

    public static ProntoShopApplication getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public AppComponent getAppComponent(){
        if (appComponent==null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}
