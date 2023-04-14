package io.github.brelee2222.mcsurvivalplayer.ai.ml.interpreter;

import io.github.brelee2222.mcsurvivalplayer.ai.ml.util.inputs.NetworkInputs;
import io.github.brelee2222.mcsurvivalplayer.ai.ml.util.neuralnetwork.NeuralNetwork;

public class SigmoidNetInterpreter implements NetworkInterpreter {
    NeuralNetwork neuralNetwork;

    public SigmoidNetInterpreter(NeuralNetwork neuralNetwork) {
        this.neuralNetwork = neuralNetwork;
    }

    @Override
    public double calculateInput(NetworkInputs inputs) {
        inputs.fromFirst();
        double output = neuralNetwork.nextWeight();
        while(inputs.hasNext()) {
            output += neuralNetwork.nextWeight() * inputs.readNext();
        }
        return 1/(1 + Math.exp(-output));
    }

    @Override
    public NetworkInputs get(NetworkInputs inputs) {
        neuralNetwork.fromStart();

        while(neuralNetwork.hasNextLayer()) {
            NetworkInputs nextInputs = inputs.makeNew(neuralNetwork.nextLayer());

            while(nextInputs.hasNext()) {
                nextInputs.writeNext(calculateInput(inputs));
            }

            inputs = nextInputs;
        }

        return inputs;
    }
}
