package com.jodelapp.jodelandroidv3;

import com.squareup.otto.Bus;

import lanchon.dexpatcher.annotation.DexAction;
import lanchon.dexpatcher.annotation.DexAdd;
import lanchon.dexpatcher.annotation.DexEdit;
import lanchon.dexpatcher.annotation.DexIgnore;
import lanchon.dexpatcher.annotation.DexWrap;

@DexEdit(staticConstructorAction = DexAction.ADD)
public class AppModule {

    @DexIgnore
    public AppModule() {
    }

    @DexAdd
    public static Bus staticBus;

    static {
    }

    @DexWrap
    private Bus createBus() {
        Bus bus = createBus();
        staticBus = bus;
        return bus;
    }
}
