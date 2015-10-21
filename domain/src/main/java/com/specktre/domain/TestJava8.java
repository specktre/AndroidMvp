package com.specktre.domain;

public class TestJava8 {

    public void test() {
        run(() -> {
            String bla = "asd";
            bla.toCharArray();
        });
    }

    public void run(Runnable runnable) {
        runnable.run();
    }
}
