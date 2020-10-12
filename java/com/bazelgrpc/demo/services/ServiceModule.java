package com.bazelgrpc.demo.services;

import com.google.inject.AbstractModule;

public class ServiceModule {

    @Override
    protected void configure() {
        bind(MainPollHandler.class).to(PollHandler.class);
    }
}
