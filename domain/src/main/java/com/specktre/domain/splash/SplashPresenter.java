package com.specktre.domain.splash;

import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;

public class SplashPresenter extends RxMvpBasePresenter<SplashView> {

    @Inject
    public SplashPresenter(RxSchedulersProvider rxSchedulersProvider) {
        super(rxSchedulersProvider);
    }

    public void startSplashPresentation() {
        displaySplashMessage();
        Observable.just(1)
                  .delay(3, TimeUnit.SECONDS)
                  .subscribeOn(getRxSchedulersProvider().subscribeOn())
                  .observeOn(getRxSchedulersProvider().observeOn())
                  .subscribe(value -> {
                      proceedToApplication();
                  });
    }

    private void displaySplashMessage() {
        runIfViewAttached(() -> getView().displaySplashMessage("Welcome to our MVP playground!"));
    }

    private void proceedToApplication() {
        runIfViewAttached(() -> getView().proceedToApplication());
    }
}
