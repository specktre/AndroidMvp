package com.specktre.androidmvp;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module
public class NetworkModule {

    public static final String GITHUB_API_URL = "https://api.github.com";

    static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    private static OkHttpClient createOkHttpClient(Application app) {
        OkHttpClient client = new OkHttpClient();
        // Install an HTTP cache in the application cache directory.
        File cacheDir = new File(app.getCacheDir(), "http");

        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        client.setCache(cache);
        client.setReadTimeout(30, TimeUnit.SECONDS);
        client.setConnectTimeout(30, TimeUnit.SECONDS);
        return client;
    }

    @Provides
    @ApplicationScope
    Endpoint provideEndpoint() {
        return Endpoints.newFixedEndpoint(GITHUB_API_URL);
    }

    @Provides
    @ApplicationScope
    GithubService provideGithubService(RestAdapter restAdapter) {
        return restAdapter.create(GithubService.class);
    }

    @Provides
    @ApplicationScope
    Client provideClient(Application app) {
        return new OkClient(createOkHttpClient(app));
    }

    @Provides
    @ApplicationScope
    RestAdapter provideRestAdapter(Endpoint endpoint, Client client, Gson gson) {
        return new RestAdapter.Builder()
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .setClient(client)
                .setConverter(new GsonConverter(gson))
                .setEndpoint(endpoint)
                .build();
    }

    @Provides
    @ApplicationScope
    Gson provideGson() {
        GsonBuilder gb = new GsonBuilder();
        gb.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);
        return gb.create();
    }
}
