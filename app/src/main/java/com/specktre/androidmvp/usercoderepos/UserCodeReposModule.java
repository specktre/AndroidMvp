package com.specktre.androidmvp.usercoderepos;

import com.specktre.androidmvp.scopes.FragmentScope;
import com.specktre.domain.usercoderepos.UserCodingLifeAnalyzer;

import dagger.Module;
import dagger.Provides;

@Module
public class UserCodeReposModule {

    @Provides
    @FragmentScope
    protected UserCodingLifeAnalyzer provideUserCodingLifeAnalyzer() {
        return new UserCodingLifeAnalyzerImpl();
    }
}
