package com.bazelgrpc.demo.action;

import io.grpc.stub.StreamObserver;
import com.bazelgrpc.demo.action.ActionManagementGrpc;
import com.bazelgrpc.demo.action.ActionServiceProto.InitializePageRequest;
import com.bazelgrpc.demo.action.ActionServiceProto.InitializePageResponse;
import com.bazelgrpc.demo.poll.PollHandler;
import java.util.List;
import com.google.inject.Inject;
import com.google.inject.AbstractModule;

public class ActionManagementImpl extends ActionManagementGrpc.ActionManagementImplBase {

  private final PollHandler pollHandler;

  @Inject
  public ActionManagementImpl(PollHandler pollHandler) {
    this.pollHandler = pollHandler;
  }

  @Override
  public void initializePage(InitializePageRequest req,
      StreamObserver<InitializePageResponse> responseObserver) {
    System.out.println("initializePage");
    System.out.println(pollHandler);

    InitializePageResponse.Builder response = InitializePageResponse.newBuilder();
    response.addAllPolls(pollHandler.getPolls());

    responseObserver.onNext(response.build());
    responseObserver.onCompleted();
  }

}
