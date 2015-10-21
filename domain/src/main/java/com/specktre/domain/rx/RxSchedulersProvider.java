package com.specktre.domain.rx;

import rx.Scheduler;

public interface RxSchedulersProvider {

    Scheduler subscribeOn();

    Scheduler observeOn();
}
