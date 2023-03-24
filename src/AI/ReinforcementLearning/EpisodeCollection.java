package AI.ReinforcementLearning;

import AI.NetworkInputs;

public interface EpisodeCollection {
    /**
     * @return if the collection can store anymore or this is the last episode
     */
    boolean addEpisode(NetworkInputs state, NetworkInputs action, double reward);
    void fromStart();

    /**
     *
     * If a buffered episode is ever made, the order this is execute is as follows.
     */
    NetworkInputs nextEpisodeState();
    NetworkInputs nextEpisodeAction();
    double nextEpisodeReward();
    boolean hasNext();
}
