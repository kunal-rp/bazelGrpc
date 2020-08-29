package com.bazelgrpc.demo.poll;

import io.grpc.stub.StreamObserver;
import com.bazelgrpc.demo.PollManagementGrpc;
import com.bazelgrpc.demo.PollServiceProto.GetPollRequest;
import com.bazelgrpc.demo.PollServiceProto.GetPollResponse;

public class PollManagementImpl extends PollManagementGrpc.PollManagementImplBase {

    @Override
    public void getPolls(GetPollRequest req, StreamObserver<GetPollResponse> responseObserver) {
        System.out.println("I just got a request !");
      responseObserver.onNext(GetPollResponse.newBuilder().addPolls(PollUtil.createTestingPoll()).build());
      responseObserver.onCompleted();
    }

}

