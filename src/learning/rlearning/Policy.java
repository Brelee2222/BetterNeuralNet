package learning.rlearning;

import util.inputs.NetworkInputs;

public interface Policy {
    public NetworkInputs getErrorSignal(NetworkInputs oldAction, NetworkInputs newAction);
    public void modifyOutput(NetworkInputs inputs);
}
