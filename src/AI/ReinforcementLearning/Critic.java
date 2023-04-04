package AI.ReinforcementLearning;

import AI.utils.MachineLearning;
import AI.utils.NetworkInputs;

public interface Critic {
    double getPredictedReward(NetworkInputs state);
    MachineLearning ML();
    NetworkInputs getError(double error);
    NetworkInputs getInputs();
}
