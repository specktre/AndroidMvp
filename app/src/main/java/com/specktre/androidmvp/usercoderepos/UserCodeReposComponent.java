package com.specktre.androidmvp.usercoderepos;

import com.specktre.androidmvp.scopes.FragmentScope;
import com.specktre.domain.usercoderepos.UserCodeReposPresenter;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {UserCodeReposModule.class})
public interface UserCodeReposComponent {

    UserCodeReposActivityFragment inject(UserCodeReposActivityFragment userCodeReposActivityFragment);

    UserCodeReposPresenter provideUserCodeReposPresenter();
}
