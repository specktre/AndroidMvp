package com.specktre.androidmvp.application;

import android.app.Application;

import com.specktre.androidmvp.application.ApplicationComponent;

public class AndroidMvpApplication extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ApplicationComponent.Initializer.init(this);
    }

    public static ApplicationComponent component() {
        return applicationComponent;
    }
}
