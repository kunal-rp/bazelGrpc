package com.bazelgrpc.demo.poll;

import io.grpc.ManagedChannelBuilder;
import com.bazelgrpc.demo.PollManagementGrpc;
import com.bazelgrpc.demo.PollServiceProto.GetPollRequest;
import com.bazelgrpc.demo.PollServiceProto.GetPollResponse;

public class PollClient extends PollManagementGrpc.PollManagementImplBase {

    public static void main(String[] args){

        PollManagementGrpc.PollManagementBlockingStub blockingStub = PollManagementGrpc.newBlockingStub(
                ManagedChannelBuilder.forAddress("3.138.33.245", 31479).usePlaintext().build());

        GetPollResponse response = blockingStub.getPolls(GetPollRequest.getDefaultInstance());
        System.out.println(response);
    }
}

