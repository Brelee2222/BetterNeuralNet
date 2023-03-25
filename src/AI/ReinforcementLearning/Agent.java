package AI.ReinforcementLearning;

import AI.MachineLearning;
import AI.NetworkInputs;
import AI.NeuralNetwork;

public interface Agent {
    NeuralNetwork network();
    NetworkInputs get(NetworkInputs inputs);
    MachineLearning ML();
    Policy policy();

    NetworkInputs getInputs();
}
