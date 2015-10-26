package com.specktre.androidmvp.userselection;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import rx.subjects.PublishSubject;

public class UserSelectionActivityFragment extends MvpViewStateFragment<UserSelectionView, UserSelectionPresenter> implements UserSelectionView {

    private UserSelectionComponent userSelectionComponent;

    @Bind(R.id.username_edit_text)
    EditText usernameEditText;

    @Bind(R.id.github_radiobutton)
    RadioButton githubRadioButton;

    @Bind(R.id.bitbucket_radiobuttion)
    RadioButton bitbucketRadioButton;

    @Bind(R.id.user_status_text_view)
    TextView userStatusTextView;

    @Bind(R.id.user_selection_next_button)
    Button nextButton;
    private PublishSubject<String> usernameChangeEvents;

    public UserSelectionActivityFragment() {
    }

    @Override
    public UserSelectionPresenter createPresenter() {
        UserSelectionPresenter userSelectionPresenter = userSelectionComponent.provideUserSelectionPresenter();
        userSelectionPresenter.whenUsernameChanges(usernameChangeEvents);
        return userSelectionPresenter;
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
        usernameChangeEvents = PublishSubject.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_selection, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                usernameChangeEvents.onNext(usernameEditText.getText().toString());
            }
        });
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
        ((UserSelectionViewState) viewState).setUsernameEditTextEnabled(false);
    }

    @Override
    public void allowUsernameSelection() {
        usernameEditText.setEnabled(true);
        usernameEditText.setHint("");
        ((UserSelectionViewState) viewState).setUsernameEditTextEnabled(true);
    }

    @Override
    public void displayUserIsFoundAndHasPublicRepos() {
        userStatusTextView.setTextColor(Color.GREEN);
        userStatusTextView.setText("User found and has public repos!");
        ((UserSelectionViewState)viewState).setUserIsFoundAndHasPublicRepos();
    }

    @Override
    public void displayErrorUserHasNoPublicRepos() {
        userStatusTextView.setTextColor(Color.parseColor("#FFA500"));
        userStatusTextView.setText("User has no public repos!");
        ((UserSelectionViewState)viewState).setUserHasNoPublicRepos();
    }

    @Override
    public void displayErrorUserIsNotFound() {
        userStatusTextView.setTextColor(Color.RED);
        userStatusTextView.setText("User not found!");
        ((UserSelectionViewState)viewState).setUserNotFound();
    }

    @Override
    public void allowProceedingToNextStep() {
        nextButton.setEnabled(true);
        ((UserSelectionViewState) viewState).setNextButtonEnabled(true);
    }

    @Override
    public void disallowProceedingToNextStep() {
        nextButton.setEnabled(false);
        ((UserSelectionViewState) viewState).setNextButtonEnabled(false);
    }
}
