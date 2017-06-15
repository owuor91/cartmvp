package io.github.owuor91.cartmvp.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.owuor91.cartmvp.ProntoShopApplication;

/**
 * Created by johnowuor on 15/06/2017.
 */

@Module
public class AppModule {
    private final ProntoShopApplication app;

    public AppModule(ProntoShopApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return app;
    }
}
