package com.bazelgrpc.demo.poll;

public class RunPollClient {

    public static void main(String[] args) {

        PollClient client = new PollClient();
        System.out.println(client.callGetPoll());
    }

}
