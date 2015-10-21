package com.specktre.domain.splash;

import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import java.util.concurrent.TimeUnit;

import rx.Observable;

public class SplashPresenter extends RxMvpBasePresenter<SplashView> {

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
                      proceedToDashboard();
                  });
    }

    private void displaySplashMessage() {
        runIfViewAttached(() -> getView().displaySplashMessage("Welcome to our MVP playground!"));
    }

    private void proceedToDashboard() {
        runIfViewAttached(() -> getView().proceedToDashboard());
    }
}
