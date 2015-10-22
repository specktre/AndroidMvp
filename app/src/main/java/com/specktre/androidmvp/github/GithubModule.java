package com.specktre.androidmvp.github;

import com.google.gson.Gson;
import com.specktre.androidmvp.BuildConfig;
import com.specktre.androidmvp.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.GsonConverter;

@Module
public class GithubModule {

    @ApplicationScope
    @Provides
    protected GithubApi provideGithubApi(Client client, Gson gson) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setClient(client)
                .setConverter(new GsonConverter(gson))
                .setEndpoint("https://api.github.com")
                .build();

        return restAdapter.create(GithubApi.class);
    }
}
