package com.bazelgrpc.demo.poll;

import java.util.List;
import com.bazelgrpc.demo.poll.PollProto.Poll;
import com.google.inject.Singleton;

@Singleton
public class MainPollHandler implements PollHandler {

    @Override
    public List<Poll> getPolls() {
        PollClient client = new PollClient();
        return client.callGetPoll().getPollsList();
    }

}
