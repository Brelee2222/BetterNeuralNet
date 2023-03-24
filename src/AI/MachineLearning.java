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

        while (neuralNetwork.hasPrevLayer()) {

            NetworkInputs nextError = errors.makeNew(neuralNetwork.prevLayer());

            errors.fromFirst();
            while (errors.hasNext()) {
                double input = inputs.next();
                errors.set(errors.next() * input * (1 - input));
            }

            errors.fromFirst();
            inputs.mark();

            while (errors.hasNext()) {
                double errorSignal = errors.next();
                nextError.fromFirst();

                while (nextError.hasNext()) {
                    double weight = neuralNetwork.prevWeight();
                    nextError.set(nextError.next() + weight * errorSignal);

                    neuralNetwork.setWeight(weight + errorSignal * inputs.next() * learningRate);
                }

                double weight = neuralNetwork.prevWeight();
                neuralNetwork.setWeight(weight + errorSignal * learningRate);

                inputs.reset();
            }

            errors = nextError;
        }

    }
}
