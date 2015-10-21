package com.specktre.androidmvp;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private AndroidMvpApplication application;

    public MainModule(AndroidMvpApplication application) {
        this.application = application;
    }

    @ApplicationScope
    @Provides
    protected Application provideApplication() {
        return application;
    }
}
