package learning.rlearning;

import util.inputs.NetworkInputs;

public interface Episode {
    public NetworkInputs getState();
    public NetworkInputs getAction();
    public double getReward();
}
