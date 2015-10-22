package com.specktre.androidmvp.splash;

import com.specktre.androidmvp.scopes.FragmentScope;
import com.specktre.domain.splash.SplashPresenter;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {

    SplashActivityFragment inject(SplashActivityFragment splashActivityFragment);

    SplashPresenter provideSplashPresenter();
}
