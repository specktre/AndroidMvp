package com.specktre.androidmvp.userselection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.specktre.androidmvp.R;
import com.specktre.androidmvp.application.AndroidMvpApplication;
import com.specktre.domain.userselection.UserSelectionPresenter;
import com.specktre.domain.userselection.UserSelectionView;

import butterknife.ButterKnife;

public class UserSelectionActivityFragment extends MvpViewStateFragment<UserSelectionView, UserSelectionPresenter> {

    private UserSelectionComponent userSelectionComponent;

    public UserSelectionActivityFragment() {
    }

    @Override
    public UserSelectionPresenter createPresenter() {
        return userSelectionComponent.provideUserSelectionPresenter();
    }

    @Override
    public ViewState createViewState() {
        return new UserSelectionViewState();
    }

    @Override
    public void onNewViewStateInstance() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        userSelectionComponent = AndroidMvpApplication.component().plus(new UserSelectionModule());
        userSelectionComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_selection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
