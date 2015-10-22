package com.specktre.domain.userselection;

import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.coderepo.CodeRepoApiProvider;
import com.specktre.domain.coderepo.CodeRepoCompany;
import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import javax.inject.Inject;

public class UserSelectionPresenter extends RxMvpBasePresenter<UserSelectionView> {

    private CodeRepoApiProvider codeRepoApiProvider;
    private CodeRepoApi selectedCodeRepoApi;

    @Inject
    public UserSelectionPresenter(RxSchedulersProvider rxSchedulersProvider, CodeRepoApiProvider codeRepoApiProvider) {
        super(rxSchedulersProvider);
        this.codeRepoApiProvider = codeRepoApiProvider;
    }

    @Override
    public void attachView(UserSelectionView view) {
        super.attachView(view);
        view.disallowUsernameSelection();
    }

    public void githubSelected() {
        selectedCodeRepoApi = codeRepoApiProvider.of(CodeRepoCompany.GITHUB);
        runIfViewAttached(() -> getView().allowUsernameSelection());
    }

    public void bitbucketSelected() {
        selectedCodeRepoApi = codeRepoApiProvider.of(CodeRepoCompany.BITBUCKET);
        runIfViewAttached(() -> getView().allowUsernameSelection());
    }
}
