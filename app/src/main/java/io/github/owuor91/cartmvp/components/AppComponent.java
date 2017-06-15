package io.github.owuor91.cartmvp.components;

import javax.inject.Singleton;

import dagger.Component;
import io.github.owuor91.cartmvp.MainActivity;
import io.github.owuor91.cartmvp.ProductPresenter;
import io.github.owuor91.cartmvp.modules.AppModule;
import io.github.owuor91.cartmvp.modules.ShoppingCartModule;

/**
 * Created by johnowuor on 15/06/2017.
 */

@Singleton
@Component(modules = {AppModule.class, ShoppingCartModule.class})
public interface AppComponent {
    void inject(ProductPresenter productPresenter);
    void inject(MainActivity mainActivity);
}
