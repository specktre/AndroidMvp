package com.specktre.androidmvp.bitbucket;

import com.specktre.domain.coderepo.CodeRepo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface BitbucketApi {

    @GET("/repositories/{user}")
    Observable<List<CodeRepo>> getUserRepos(@Path("user") String username);
}
