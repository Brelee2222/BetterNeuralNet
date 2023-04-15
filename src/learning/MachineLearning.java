package learning;

import util.inputs.NetworkInputs;
import util.neuralnetwork.NeuralNetwork;

public class MachineLearning {
    public double learningRate;
    public NeuralNetwork neuralNetwork;

    public MachineLearning(NeuralNetwork neuralNetwork, double learningRate) {
        this.learningRate = learningRate;
        this.neuralNetwork = neuralNetwork;
    }

    public void backpropagation(NetworkInputs errors, NetworkInputs inputs) {
        neuralNetwork.fromEnd();
        inputs.fromFirst();

        NetworkInputs nextError;
        while (neuralNetwork.hasPrevLayer()) {

            nextError = errors.makeNew(neuralNetwork.prevLayer());

            errors.fromFirst();
            double input;
            while (errors.hasNext()) {
                input = inputs.readNext();
                errors.write(errors.readNext() * input * (1 - input));
            }

            errors.fromFirst();
            inputs.mark();

            while (errors.hasNext()) {
                double errorSignal = errors.readNext();
                nextError.fromFirst();

                double weight;
                while (nextError.hasNext()) {
                    weight = neuralNetwork.prevWeight();
                    nextError.write(nextError.readNext() + weight * errorSignal);

                    neuralNetwork.setWeight(weight + errorSignal * inputs.readNext() * learningRate);
                }

                neuralNetwork.setWeight(neuralNetwork.prevWeight() + errorSignal * learningRate);

                inputs.reset();
            }

            errors = nextError;
        }

    }
}