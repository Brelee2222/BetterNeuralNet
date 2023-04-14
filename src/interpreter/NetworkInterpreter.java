package interpreter;

import util.inputs.NetworkInputs;

public interface NetworkInterpreter {
    public double calculateInput(NetworkInputs inputs);

    public NetworkInputs get(NetworkInputs inputs);
}
