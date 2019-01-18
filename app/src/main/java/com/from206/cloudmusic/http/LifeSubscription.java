package com.from206.cloudmusic.http;

import rx.Subscription;

public interface LifeSubscription{
    void bindSubscription(Subscription subscription);
}

