package com.specktre.domain.usercoderepos;

import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import javax.inject.Inject;

public class UserCodeReposPresenter extends RxMvpBasePresenter<UserCodeReposView> {

    private CodeRepoApi codeRepoApi;

    @Inject
    public UserCodeReposPresenter(RxSchedulersProvider rxSchedulersProvider, CodeRepoApi codeRepoApi) {
        super(rxSchedulersProvider);
        this.codeRepoApi = codeRepoApi;
    }
}
