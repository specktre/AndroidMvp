package com.specktre.androidmvp.usercoderepos;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.specktre.androidmvp.R;
import com.specktre.androidmvp.application.AndroidMvpApplication;
import com.specktre.domain.usercoderepos.UserCodeReposPresenter;
import com.specktre.domain.usercoderepos.UserCodeReposView;
import com.specktre.domain.usercoderepos.UserCodingLifeViewModel;

import butterknife.ButterKnife;

public class UserCodeReposActivityFragment extends MvpLceFragment<SwipeRefreshLayout, UserCodingLifeViewModel, UserCodeReposView,
        UserCodeReposPresenter>
        implements UserCodeReposView {

    public static final String USERCODEREPOS_USERNAME_FRAGMENT_ARG = "com.specktre.androidmvp.usercoderepos.username_fragment_arg";
    private String username;
    private UserCodeReposComponent userCodeReposComponent;

    public static UserCodeReposActivityFragment newFragment(String username) {
        UserCodeReposActivityFragment fragment = new UserCodeReposActivityFragment();
        Bundle args = new Bundle();
        args.putString(USERCODEREPOS_USERNAME_FRAGMENT_ARG, username);
        fragment.setArguments(args);
        return fragment;
    }

    public UserCodeReposActivityFragment() {
    }

    @Override
    public UserCodeReposPresenter createPresenter() {
        return userCodeReposComponent.provideUserCodeReposPresenter();
    }

    @Override
    protected String getErrorMessage(Throwable throwable, boolean pullToRefresh) {
        return throwable.toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString(USERCODEREPOS_USERNAME_FRAGMENT_ARG);
        setRetainInstance(true);
        userCodeReposComponent = AndroidMvpApplication.getCodeRepoComponent().plus(new UserCodeReposModule());
        userCodeReposComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_code_repos, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setData(UserCodingLifeViewModel data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }

    @Override
    public String getUsername() {
        return username;
    }
}
