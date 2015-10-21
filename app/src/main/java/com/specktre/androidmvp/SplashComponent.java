package com.specktre.androidmvp;

import com.specktre.domain.splash.SplashPresenter;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {

    SplashActivityFragment inject(SplashActivityFragment splashActivityFragment);

    SplashPresenter provideSplashPresenter();
}
