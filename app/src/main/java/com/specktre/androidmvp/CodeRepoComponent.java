package com.specktre.androidmvp;

import com.specktre.androidmvp.scopes.CodeRepoScope;
import com.specktre.androidmvp.usercoderepos.UserCodeReposComponent;
import com.specktre.androidmvp.usercoderepos.UserCodeReposModule;

import dagger.Subcomponent;

@CodeRepoScope
@Subcomponent(modules = {CodeRepoModule.class})
public interface CodeRepoComponent {

    UserCodeReposComponent plus(UserCodeReposModule userCodeReposModule);
}
