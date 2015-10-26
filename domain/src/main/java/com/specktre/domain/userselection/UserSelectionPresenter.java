package com.specktre.domain.userselection;

import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.coderepo.CodeRepoApiProvider;
import com.specktre.domain.coderepo.CodeRepoCompany;
import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;

public class UserSelectionPresenter extends RxMvpBasePresenter<UserSelectionView> {

    private CodeRepoApiProvider codeRepoApiProvider;
    private CodeRepoApi selectedCodeRepoApi;
    private Subscription subscriptionOnUsernameChange;
    private String selectedUsername;
    private boolean allowSearchForUserRepos;

    @Inject
    public UserSelectionPresenter(RxSchedulersProvider rxSchedulersProvider, CodeRepoApiProvider codeRepoApiProvider) {
        super(rxSchedulersProvider);
        this.codeRepoApiProvider = codeRepoApiProvider;
    }

    public void githubSelected() {
        selectedCodeRepoApi = codeRepoApiProvider.of(CodeRepoCompany.GITHUB);
        allowSearchForUserRepos = true;
        runIfViewAttached(() -> getView().allowUsernameSelection());
        if(selectedUsername != null) {
            reactOnUsernameChange(selectedUsername);
        }
    }

    public void bitbucketSelected() {
        selectedCodeRepoApi = codeRepoApiProvider.of(CodeRepoCompany.BITBUCKET);
        allowSearchForUserRepos = true;
        runIfViewAttached(() -> getView().allowUsernameSelection());
        if(selectedUsername != null) {
            reactOnUsernameChange(selectedUsername);
        }
    }

    public void whenUsernameChanges(Observable<String> usernameChangeEvents) {
        if(subscriptionOnUsernameChange != null) {
            subscriptionOnUsernameChange.unsubscribe();
        }
        subscriptionOnUsernameChange = usernameChangeEvents
                .debounce(500, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribe(username -> reactOnUsernameChange(username));
    }

    private void reactOnUsernameChange(String newUsername) {
        selectedUsername = newUsername;
        if(allowSearchForUserRepos == false) {
            return;
        }
        selectedCodeRepoApi.getUserRepos(newUsername)
                           .subscribeOn(getRxSchedulersProvider().subscribeOn())
                           .observeOn(getRxSchedulersProvider().observeOn())
                           .subscribe(userRepos -> {
                               if(userRepos.size() == 0) {
                                   userHasNoPublicRepos();
                               } else {
                                   userFoundAndHasPublicRepos();
                               }
                           }, error -> {
                               if(error.toString().contains("404")) {
                                   userNotFound();
                               }
                           });
    }

    private void userNotFound() {
        runIfViewAttached(() -> {
            getView().displayErrorUserIsNotFound();
            getView().disallowProceedingToNextStep();
        });
    }

    private void userFoundAndHasPublicRepos() {
        runIfViewAttached(() -> {
            getView().displayUserIsFoundAndHasPublicRepos();
            getView().allowProceedingToNextStep();
        });
    }

    private void userHasNoPublicRepos() {
        runIfViewAttached(() -> {
            getView().displayErrorUserHasNoPublicRepos();
            getView().disallowProceedingToNextStep();
        });
    }
}
