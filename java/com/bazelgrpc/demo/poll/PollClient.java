package com.bazelgrpc.demo.poll;

import io.grpc.ManagedChannelBuilder;
import com.bazelgrpc.demo.util.SetupUtil;
import com.bazelgrpc.demo.poll.PollManagementGrpc;
import com.bazelgrpc.demo.poll.PollServiceProto.GetPollRequest;
import com.bazelgrpc.demo.poll.PollServiceProto.GetPollResponse;

public class PollClient {

    public static void main(String[] args) {
        PollManagementGrpc.PollManagementBlockingStub blockingStub =
                PollManagementGrpc.newBlockingStub(ManagedChannelBuilder
                        .forTarget(SetupUtil.getTarget("poll")).usePlaintext().build());
        GetPollResponse response = blockingStub.getPolls(GetPollRequest.getDefaultInstance());
    }
}

