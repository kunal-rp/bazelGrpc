package com.bazelgrpc.demo.services;

import com.bazelgrpc.demo.poll.PollManagementImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.bazelgrpc.demo.util.SetupUtil;


public class PollService {

    public static void main(String[] args) throws Exception {

        Server pollServer = ServerBuilder.forPort(SetupUtil.getPort("poll"))
                .addService(new PollManagementImpl()).build();
        pollServer.start();
        System.out.println("Poll Server Started1!");
        pollServer.awaitTermination();
    }
}
