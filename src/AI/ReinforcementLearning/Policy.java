package AI.ReinforcementLearning;

import AI.NetworkInputs;

public interface Policy {
    void modifyAction(NetworkInputs action);
    void modifyErrors(NetworkInputs errors);
}
