package com.specktre.androidmvp;

import android.app.Application;

import com.specktre.domain.rx.RxSchedulersProvider;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

    @ApplicationScope
    @Provides
    protected RxSchedulersProvider provideRxSchedulersProvider() {
        return new RxSchedulersProvider() {
            @Override
            public Scheduler subscribeOn() {
                return Schedulers.io();
            }

            @Override
            public Scheduler observeOn() {
                return AndroidSchedulers.mainThread();
            }
        };
    }
}
