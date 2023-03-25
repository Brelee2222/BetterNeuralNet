package AI;

public class MachineLearning {
    public double learningRate;
    public NeuralNetwork neuralNetwork;

    public MachineLearning(NeuralNetwork neuralNetwork, double learningRate) {
        this.learningRate = learningRate;
        this.neuralNetwork = neuralNetwork;
    }

    public void learn(NetworkInputs errors, NetworkInputs inputs) {
        neuralNetwork.fromEnd();
        inputs.fromFirst();

        NetworkInputs nextError;
        while (neuralNetwork.hasPrevLayer()) {

            nextError = errors.makeNew(neuralNetwork.prevLayer());

            errors.fromFirst();
            double input;
            while (errors.hasNext()) {
                input = inputs.next();
                errors.set(errors.next() * input * (1 - input));
            }

            errors.fromFirst();
            inputs.mark();

            while (errors.hasNext()) {
                double errorSignal = errors.next();
                nextError.fromFirst();

                double weight;
                while (nextError.hasNext()) {
                    weight = neuralNetwork.prevWeight();
                    nextError.set(nextError.next() + weight * errorSignal);

                    neuralNetwork.setWeight(weight + errorSignal * inputs.next() * learningRate);
                }

                neuralNetwork.setWeight(neuralNetwork.prevWeight() + errorSignal * learningRate);

                inputs.reset();
            }

            errors = nextError;
        }

    }
}
