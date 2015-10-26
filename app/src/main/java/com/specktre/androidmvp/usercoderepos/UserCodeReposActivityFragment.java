package com.specktre.androidmvp.usercoderepos;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.specktre.androidmvp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class UserCodeReposActivityFragment extends Fragment {

    public UserCodeReposActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_code_repos, container, false);
    }
}
