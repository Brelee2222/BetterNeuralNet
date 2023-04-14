package io.github.brelee2222.mcsurvivalplayer.ai.ml.interpreter;

import io.github.brelee2222.mcsurvivalplayer.ai.ml.util.inputs.NetworkInputs;

public interface NetworkInterpreter {
    public double calculateInput(NetworkInputs inputs);

    public NetworkInputs get(NetworkInputs inputs);
}
