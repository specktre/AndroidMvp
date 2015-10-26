package com.specktre.androidmvp.userselection;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.specktre.domain.userselection.UserSelectionView;

public class UserSelectionViewState implements ViewState<UserSelectionView> {
    private boolean usernameEditTextEnabled;
    private boolean nextButtonEnabled;

    private enum UserRepoState {
        HAS_PUBLIC_REPOS, NO_PUBLIC_REPOS, USER_NOT_FOUND
    }

    private UserRepoState userRepoState;

    @Override
    public void apply(UserSelectionView userSelectionView, boolean retained) {
        if(usernameEditTextEnabled) {
            userSelectionView.allowUsernameSelection();
        } else {
            userSelectionView.disallowUsernameSelection();
        }

        if(nextButtonEnabled) {
            userSelectionView.allowProceedingToNextStep();
        } else {
            userSelectionView.disallowProceedingToNextStep();
        }

        switch(userRepoState) {
            case HAS_PUBLIC_REPOS:
                userSelectionView.displayUserIsFoundAndHasPublicRepos();
                break;
            case NO_PUBLIC_REPOS:
                userSelectionView.displayErrorUserHasNoPublicRepos();
                break;
            case USER_NOT_FOUND:
                userSelectionView.displayErrorUserIsNotFound();
                break;
        }
    }

    public void setUsernameEditTextEnabled(boolean enabled) {
        this.usernameEditTextEnabled = enabled;
    }

    public void setNextButtonEnabled(boolean enabled) {
        this.nextButtonEnabled = enabled;
    }

    public void setUserIsFoundAndHasPublicRepos() {
        userRepoState = UserRepoState.HAS_PUBLIC_REPOS;
    }

    public void setUserHasNoPublicRepos() {
        userRepoState = UserRepoState.NO_PUBLIC_REPOS;
    }

    public void setUserNotFound() {
        userRepoState = UserRepoState.USER_NOT_FOUND;
    }
}
