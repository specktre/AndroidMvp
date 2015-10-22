package com.specktre.androidmvp.userselection;

import com.specktre.androidmvp.scopes.FragmentScope;
import com.specktre.domain.userselection.UserSelectionPresenter;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {UserSelectionModule.class})
public interface UserSelectionComponent {

    UserSelectionActivityFragment inject(UserSelectionActivityFragment userSelectionActivityFragment);

    UserSelectionPresenter provideUserSelectionPresenter();
}
