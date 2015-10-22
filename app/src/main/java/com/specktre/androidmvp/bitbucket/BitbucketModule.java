package com.specktre.androidmvp.bitbucket;

import com.google.gson.Gson;
import com.specktre.androidmvp.BuildConfig;
import com.specktre.androidmvp.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.GsonConverter;

@Module
public class BitbucketModule {

    @ApplicationScope
    @Provides
    protected BitbucketApi provideGithubApi(Client client, Gson gson) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setClient(client)
                .setConverter(new GsonConverter(gson))
                .setEndpoint("https://api.bitbucket.org/2.0")
                .build();

        return restAdapter.create(BitbucketApi.class);
    }
}
