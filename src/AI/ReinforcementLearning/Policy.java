package AI.ReinforcementLearning;

import AI.utils.NetworkInputs;

public interface Policy {
    void modifyAction(NetworkInputs action);
    NetworkInputs getErrors(NetworkInputs action, NetworkInputs newAction, double error);
}
