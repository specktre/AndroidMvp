package com.specktre.androidmvp;

import android.app.Application;

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
