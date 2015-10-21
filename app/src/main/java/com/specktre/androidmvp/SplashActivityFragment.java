package com.specktre.androidmvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.specktre.domain.rx.RxSchedulersProvider;
import com.specktre.domain.splash.SplashPresenter;
import com.specktre.domain.splash.SplashView;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SplashActivityFragment extends MvpFragment<SplashView, SplashPresenter> implements SplashView {

    @Bind(R.id.splash_text_view)
    TextView splashTextView;
    private SplashComponent splashComponent;

    public SplashActivityFragment() {
    }

    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter(new RxSchedulersProvider() {
            @Override
            public Scheduler subscribeOn() {
                return Schedulers.io();
            }

            @Override
            public Scheduler observeOn() {
                return AndroidSchedulers.mainThread();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        splashComponent = AndroidMvpApplication.component().plus(new SplashModule());
        splashComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.startSplashPresentation();
    }

    @Override
    public void displaySplashMessage(String splashMessage) {
        splashTextView.setText(splashMessage);
    }

    @Override
    public void proceedToDashboard() {
        splashTextView.setText("Dashboard");
    }
}
