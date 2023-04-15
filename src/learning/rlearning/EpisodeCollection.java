package learning.rlearning;

import util.inputs.NetworkInputs;

public interface EpisodeCollection {
    public boolean record(NetworkInputs state, NetworkInputs action, double reward);
    public void fromLast();
    public EpisodeCollection getPrevEpisode();
}
