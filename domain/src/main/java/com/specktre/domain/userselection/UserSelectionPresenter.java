package com.specktre.domain.userselection;

import com.specktre.domain.coderepo.CodeRepoApiProvider;
import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import javax.inject.Inject;

public class UserSelectionPresenter extends RxMvpBasePresenter<UserSelectionView> {

    private CodeRepoApiProvider codeRepoApiProvider;

    @Inject
    public UserSelectionPresenter(RxSchedulersProvider rxSchedulersProvider, CodeRepoApiProvider codeRepoApiProvider) {
        super(rxSchedulersProvider);
        this.codeRepoApiProvider = codeRepoApiProvider;
    }
}
