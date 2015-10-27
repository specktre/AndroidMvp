package com.specktre.androidmvp;

import com.specktre.androidmvp.scopes.CodeRepoScope;
import com.specktre.domain.coderepo.CodeRepoApi;
import com.specktre.domain.coderepo.CodeRepoApiProvider;
import com.specktre.domain.coderepo.CodeRepoCompany;

import dagger.Module;
import dagger.Provides;

@Module
public class CodeRepoModule {

    private CodeRepoCompany codeRepoCompany;

    public CodeRepoModule(CodeRepoCompany codeRepoCompany) {
        this.codeRepoCompany = codeRepoCompany;
    }

    @Provides
    @CodeRepoScope
    protected CodeRepoApi provideCodeRepoApi(CodeRepoApiProvider codeRepoApiProvider) {
        return codeRepoApiProvider.of(codeRepoCompany);
    }
}
