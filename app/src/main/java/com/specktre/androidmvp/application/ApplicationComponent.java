package com.specktre.androidmvp.application;

import com.specktre.androidmvp.bitbucket.BitbucketModule;
import com.specktre.androidmvp.github.GithubModule;
import com.specktre.androidmvp.scopes.ApplicationScope;
import com.specktre.androidmvp.splash.SplashComponent;
import com.specktre.androidmvp.splash.SplashModule;
import com.specktre.androidmvp.userselection.UserSelectionComponent;
import com.specktre.androidmvp.userselection.UserSelectionModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {MainModule.class, NetworkModule.class, GithubModule.class, BitbucketModule.class})
public interface ApplicationComponent {

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static ApplicationComponent init(AndroidMvpApplication app) {
            return DaggerApplicationComponent.builder().mainModule(new MainModule(app)).build();
        }
    }

    SplashComponent plus(SplashModule splashModule);

    UserSelectionComponent plus(UserSelectionModule userSelectionModule);
}
