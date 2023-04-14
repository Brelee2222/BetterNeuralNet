package io.github.brelee2222.mcsurvivalplayer.ai.ml.learning;

import io.github.brelee2222.mcsurvivalplayer.ai.ml.util.inputs.NetworkInputs;

public interface MachineLearning {
    public void backpropagation(NetworkInputs errors, NetworkInputs inputs);
}