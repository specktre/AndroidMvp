package com.specktre.androidmvp;

import com.specktre.androidmvp.bitbucket.BitbucketApi;
import com.specktre.androidmvp.bitbucket.BitbucketCodeRepoApi;
import com.specktre.androidmvp.github.GithubApi;
import com.specktre.androidmvp.github.GithubCodeRepoApi;
import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.coderepo.CodeRepoApiProvider;
import com.specktre.domain.coderepo.CodeRepoCompany;

public class WorldCodeRepoApiProvider implements CodeRepoApiProvider {

    private final GithubApi githubApi;
    private final BitbucketApi bitbucketApi;

    public WorldCodeRepoApiProvider(GithubApi githubApi, BitbucketApi bitbucketApi) {
        this.githubApi = githubApi;
        this.bitbucketApi = bitbucketApi;
    }

    @Override
    public CodeRepoApi of(CodeRepoCompany codeRepoCompany) {
        switch(codeRepoCompany) {
            case GITHUB:
                return new GithubCodeRepoApi(githubApi);
            case BITBUCKET:
                return new BitbucketCodeRepoApi(bitbucketApi);
            default:
                throw new RuntimeException("Unsupported CodeRepoCompany " + codeRepoCompany.toString());
        }
    }
}
