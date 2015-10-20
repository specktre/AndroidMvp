package com.specktre.mvp;

public class MyClass {

    public void doSomething() {
        run(() -> {
            String bla = "bla";
        });
    }

    public void run(Runnable runnable) {
        runnable.run();
    }
}
