package com.specktre.androidmvp.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.specktre.androidmvp.R;
import com.specktre.androidmvp.application.AndroidMvpApplication;
import com.specktre.androidmvp.userselection.UserSelectionActivity;
import com.specktre.domain.splash.SplashPresenter;
import com.specktre.domain.splash.SplashView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivityFragment extends MvpFragment<SplashView, SplashPresenter> implements SplashView {

    @Bind(R.id.splash_text_view)
    TextView splashTextView;

    private SplashComponent splashComponent;

    public SplashActivityFragment() {
    }

    @Override
    public SplashPresenter createPresenter() {
        return splashComponent.provideSplashPresenter();
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
    public void proceedToApplication() {
        startActivity(UserSelectionActivity.newIntent(this.getContext()));
    }
}
