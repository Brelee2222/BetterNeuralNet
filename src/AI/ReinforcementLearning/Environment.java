package AI.ReinforcementLearning;

import AI.NetworkInputs;

public interface Environment {
    NetworkInputs get();
    double react(NetworkInputs action);
    double getMaxReward();
}
