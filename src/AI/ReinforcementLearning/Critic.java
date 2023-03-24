package AI.ReinforcementLearning;

import AI.NetworkInputs;
import AI.NeuralNetwork;

public interface Critic {
    double getPredictedReward(NetworkInputs state);
    NeuralNetwork network();
}
