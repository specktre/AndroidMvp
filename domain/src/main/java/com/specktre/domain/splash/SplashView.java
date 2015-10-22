package com.specktre.domain.splash;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface SplashView extends MvpView {

    void displaySplashMessage(String splashMessage);

    void proceedToApplication();
}
