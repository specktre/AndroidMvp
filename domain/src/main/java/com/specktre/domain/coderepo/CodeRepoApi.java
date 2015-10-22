package com.specktre.domain.coderepo;

import java.util.List;

import rx.Observable;

public interface CodeRepoApi {

    Observable<List<CodeRepo>> getUserRepos(String username);
}
