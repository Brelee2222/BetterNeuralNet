package AI.ReinforcementLearning;

import AI.MachineLearning;
import AI.NetworkInputs;
import AI.NeuralNetwork;

public interface Critic {
    double getPredictedReward(NetworkInputs state);
    MachineLearning ML();
    NetworkInputs getError(double error);
    NetworkInputs getInputs();
}
