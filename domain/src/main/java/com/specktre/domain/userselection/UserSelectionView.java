package com.specktre.domain.userselection;

import com.hannesdorfmann.mosby.mvp.MvpView;

public interface UserSelectionView extends MvpView {
    void disallowUsernameSelection();

    void allowUsernameSelection();

    void displayUserIsFoundAndHasPublicRepos();

    void displayErrorUserHasNoPublicRepos();

    void displayErrorUserIsNotFound();

    void allowProceedingToNextStep();

    void disallowProceedingToNextStep();
}
