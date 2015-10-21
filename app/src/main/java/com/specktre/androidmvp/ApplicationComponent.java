package com.specktre.androidmvp;

import dagger.Component;

@ApplicationScope
@Component(modules = {MainModule.class, NetworkModule.class})
public interface ApplicationComponent {

    final class Initializer {
        private Initializer() {
        } // No instances.

        public static ApplicationComponent init(AndroidMvpApplication app) {
            return DaggerApplicationComponent.builder().mainModule(new MainModule(app)).build();
        }
    }
}
