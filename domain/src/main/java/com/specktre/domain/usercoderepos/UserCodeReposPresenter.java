package com.specktre.domain.usercoderepos;

import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.rx.RxMvpBasePresenter;
import com.specktre.domain.rx.RxSchedulersProvider;

import javax.inject.Inject;

public class UserCodeReposPresenter extends RxMvpBasePresenter<UserCodeReposView> {

    private CodeRepoApi codeRepoApi;
    private UserCodingLifeAnalyzer userCodingLifeAnalyzer;
    private String username;

    @Inject
    public UserCodeReposPresenter(RxSchedulersProvider rxSchedulersProvider,
                                  CodeRepoApi codeRepoApi,
                                  UserCodingLifeAnalyzer userCodingLifeAnalyzer) {
        super(rxSchedulersProvider);
        this.codeRepoApi = codeRepoApi;
        this.userCodingLifeAnalyzer = userCodingLifeAnalyzer;
    }

    @Override
    public void attachView(UserCodeReposView view) {
        super.attachView(view);
        username = getView().getUsername();
        codeRepoApi.getUserRepos(username)
                   .subscribeOn(getRxSchedulersProvider().subscribeOn())
                   .observeOn(getRxSchedulersProvider().observeOn())
                   .subscribe(userCodeRepos -> {
                                  runIfViewAttached(() -> {
                                      boolean isStar = userCodingLifeAnalyzer.isStar(userCodeRepos);
                                      boolean isJavaProgrammer = userCodingLifeAnalyzer.isProgrammerInLanguage("Java", userCodeRepos);
                                      String mostRatedRepo = userCodingLifeAnalyzer.mostRatedRepo(userCodeRepos);
                                      getView().setData(new UserCodingLifeViewModel(isJavaProgrammer, isStar, mostRatedRepo));
                                      getView().showContent();
                                  });
                              },
                              error -> {
                                  getView().showError(error, false);
                              });
    }
}
