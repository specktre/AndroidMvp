package com.specktre.domain.rx;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

public class RxMvpBasePresenter<V extends MvpView> extends MvpBasePresenter<V> {

    private RxSchedulersProvider rxSchedulersProvider;

    public RxMvpBasePresenter(RxSchedulersProvider rxSchedulersProvider) {
        if(rxSchedulersProvider == null) {
            throw new NullPointerException("rxSchedulersProvider parameter in " + getClass().getSimpleName());
        }
        this.rxSchedulersProvider = rxSchedulersProvider;
    }

    protected RxSchedulersProvider getRxSchedulersProvider() {
        return rxSchedulersProvider;
    }

    protected void runIfViewAttached(Runnable runnable) {
        if(isViewAttached()) {
            runnable.run();
        }
    }
}
