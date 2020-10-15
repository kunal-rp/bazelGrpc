package com.bazelgrpc.demo.action;

import io.grpc.ManagedChannelBuilder;
import com.bazelgrpc.demo.util.SetupUtil;
import com.bazelgrpc.demo.action.ActionManagementGrpc;
import com.bazelgrpc.demo.action.ActionServiceProto.InitializePageRequest;
import com.bazelgrpc.demo.action.ActionServiceProto.InitializePageResponse;

public class ActionClient {

    public static void main(String[] args) {
        ActionManagementGrpc.ActionManagementBlockingStub blockingStub =
                ActionManagementGrpc.newBlockingStub(
                        ManagedChannelBuilder.forTarget("localhost:30007").usePlaintext().build());
        InitializePageResponse response =
                blockingStub.initializePage(InitializePageRequest.getDefaultInstance());
        System.out.println(response);
    }
}

