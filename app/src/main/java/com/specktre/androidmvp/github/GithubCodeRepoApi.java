package com.specktre.androidmvp.github;

import com.specktre.domain.coderepo.CodeRepo;
import com.specktre.domain.coderepo.CodeRepoApi;

import java.util.List;

import rx.Observable;

public class GithubCodeRepoApi implements CodeRepoApi {

    private GithubApi githubApi;

    public GithubCodeRepoApi(GithubApi githubApi) {
        this.githubApi = githubApi;
    }

    @Override
    public Observable<List<CodeRepo>> getUserRepos(String username) {
        return githubApi.getUserRepos(username);
    }
}
