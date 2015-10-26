package com.specktre.androidmvp.usercoderepos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.specktre.androidmvp.R;

public class UserCodeReposActivityFragment extends Fragment {

    public static final String USERCODEREPOS_USERNAME_FRAGMENT_ARG = "com.specktre.androidmvp.usercoderepos.username_fragment_arg";
    private String username;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        username = getArguments().getString(USERCODEREPOS_USERNAME_FRAGMENT_ARG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_code_repos, container, false);
    }
}
