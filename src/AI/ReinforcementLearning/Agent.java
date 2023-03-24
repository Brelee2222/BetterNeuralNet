package AI.ReinforcementLearning;

import AI.NetworkInputs;
import AI.NeuralNetwork;

public interface Agent {
    NeuralNetwork network();
    NetworkInputs get(NetworkInputs inputs);
}
