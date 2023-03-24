package AI.ReinforcementLearning;

import AI.NetworkInputs;

public class RLearning {
    Critic critic;
    Agent agent;

    public void train(Environment environment, EpisodeCollection episodeCollection) {
        NetworkInputs state;
        NetworkInputs action;
        do {
            state = environment.get();
            action = agent.get(state);
        } while(episodeCollection.addEpisode(state, action, environment.react(action)));
    }
}
