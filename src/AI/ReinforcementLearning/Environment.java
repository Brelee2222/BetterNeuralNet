package AI.ReinforcementLearning;

import AI.utils.NetworkInputs;

public interface Environment {
    NetworkInputs get();
    double react(NetworkInputs action);
    double getMaxReward();
}
