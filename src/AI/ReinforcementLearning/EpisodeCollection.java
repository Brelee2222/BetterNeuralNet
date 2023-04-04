package AI.ReinforcementLearning;

import AI.utils.NetworkInputs;

public interface EpisodeCollection {
    /**
     * @return if the collection can store anymore or this is the last episode
     */
    boolean addEpisode(NetworkInputs state, NetworkInputs action, double reward);

    /**
     *
     * If a buffered episode is ever made, the order this is executed is the revers of as follows.
     * By the time this sequence of functions are executed, Episode should be at the last episode.
     */
    NetworkInputs prevEpisodeAction();
    NetworkInputs prevEpisodeState();
    double prevEpisodeReward();
    boolean hasPrev();
}
