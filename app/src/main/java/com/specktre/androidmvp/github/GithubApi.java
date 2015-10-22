package com.specktre.androidmvp.github;

import com.specktre.domain.coderepo.CodeRepo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GithubApi {

    @GET("/users/{user}/repos")
    Observable<List<CodeRepo>> getUserRepos(@Path("user") String username);
}
