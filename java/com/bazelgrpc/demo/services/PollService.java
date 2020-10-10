package com.bazelgrpc.demo.services;

import com.bazelgrpc.demo.poll.PollManagementImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;


public class PollService {

    public static void main(String[] args) throws Exception {

        Server pollServer = ServerBuilder.forPort(8080)
                .addService(new PollManagementImpl())
                .build();
        pollServer.start();
        System.out.println("Poll Server Started1!");
        pollServer.awaitTermination();
    }
}