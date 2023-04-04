package AI.ReinforcementLearning;

import AI.utils.MachineLearning;
import AI.utils.NetworkInputs;
import AI.utils.NeuralNetwork;

public interface Agent {
    NeuralNetwork network();
    NetworkInputs get(NetworkInputs inputs);
    MachineLearning ML();
    Policy policy();

    NetworkInputs getInputs();
}
