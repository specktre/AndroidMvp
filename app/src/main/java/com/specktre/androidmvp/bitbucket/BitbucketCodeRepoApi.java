package com.specktre.androidmvp.bitbucket;

import com.specktre.domain.coderepo.CodeRepo;
import com.specktre.domain.coderepo.CodeRepoApi;

import java.util.List;

import rx.Observable;

public class BitbucketCodeRepoApi implements CodeRepoApi {

    private BitbucketApi bitbucketApi;

    public BitbucketCodeRepoApi(BitbucketApi bitbucketApi) {
        this.bitbucketApi = bitbucketApi;
    }

    @Override
    public Observable<List<CodeRepo>> getUserRepos(String username) {
        return bitbucketApi.getUserRepos(username);
    }
}
