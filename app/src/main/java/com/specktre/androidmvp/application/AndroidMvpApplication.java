package com.specktre.androidmvp.application;

import android.app.Application;

import com.specktre.androidmvp.CodeRepoComponent;
import com.specktre.androidmvp.CodeRepoModule;
import com.specktre.domain.coderepo.CodeRepoCompany;

public class AndroidMvpApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private static CodeRepoComponent codeRepoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = ApplicationComponent.Initializer.init(this);
    }

    public static ApplicationComponent component() {
        return applicationComponent;
    }

    public static CodeRepoComponent createCodeRepoComponent(CodeRepoCompany codeRepoCompany) {
        codeRepoComponent = component().plus(new CodeRepoModule(codeRepoCompany));
        return codeRepoComponent;
    }

    public static CodeRepoComponent getCodeRepoComponent() {
        return codeRepoComponent;
    }

    public static void destroyCodeRepoComponent() {
        codeRepoComponent = null;
    }
}
