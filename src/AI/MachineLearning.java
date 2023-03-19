package AI;

public class MachineLearning {
    public double learningRate;
    public NeuralNetwork neuralNetwork;

    public MachineLearning(NeuralNetwork neuralNetwork, double learningRate) {
        this.learningRate = learningRate;
        this.neuralNetwork = neuralNetwork;
    }

    public void learn(NetworkInputs errors, NetworkInputs inputs) {
        NetworkInputs weights = neuralNetwork.weights();
        neuralNetwork.fromEnd();
        inputs.fromLast();

        while (neuralNetwork.hasPrevLayer()) {

            NetworkInputs nextError = errors.makeNew(neuralNetwork.prevLayer());

            errors.fromLast();
            while (errors.hasPrev()) {
                double input = inputs.prev();
                errors.set(errors.prev() * input * (1 - input));
            }

            errors.fromLast();
            inputs.mark();

            while (errors.hasPrev()) {
                double errorSignal = errors.prev();
                nextError.fromLast();
                while (nextError.hasPrev()) {
                    double weight = weights.prev();
                    nextError.set(nextError.prev() + weight * errorSignal);

                    weights.set(weight + errorSignal * inputs.prev() * learningRate);
                }

                double weight = weights.prev();
                weights.set(weight + errorSignal * learningRate);

                inputs.reset();
            }

            errors = nextError;
        }

    }
}
