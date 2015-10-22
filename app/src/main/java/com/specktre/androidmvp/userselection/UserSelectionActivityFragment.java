package com.specktre.androidmvp.userselection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.specktre.androidmvp.R;
import com.specktre.androidmvp.application.AndroidMvpApplication;
import com.specktre.domain.userselection.UserSelectionPresenter;
import com.specktre.domain.userselection.UserSelectionView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSelectionActivityFragment extends MvpViewStateFragment<UserSelectionView, UserSelectionPresenter> implements UserSelectionView {

    private UserSelectionComponent userSelectionComponent;

    @Bind(R.id.username_edit_text)
    EditText usernameEditText;

    @Bind(R.id.github_radiobutton)
    RadioButton githubRadioButton;

    @Bind(R.id.bitbucket_radiobuttion)
    RadioButton bitbucketRadioButton;

    @Bind(R.id.user_status_text_view)
    TextView user_status_text_view;

    @Bind(R.id.user_selection_next_button)
    Button nextButton;

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

    @OnClick(R.id.github_radiobutton)
    public void onGithubRadioButtonClick(View view) {
        presenter.githubSelected();
    }

    @OnClick(R.id.bitbucket_radiobuttion)
    public void onBitbucketRadioButtonClick(View view) {
        presenter.bitbucketSelected();
    }

    @Override
    public void disallowUsernameSelection() {
        usernameEditText.setEnabled(false);
    }

    @Override
    public void allowUsernameSelection() {
        usernameEditText.setEnabled(true);
    }
}
