package AI;

public class AI {
    public static NetworkInputs get(NeuralNetwork neuralNetwork, NetworkInputs inputs) {
        neuralNetwork.fromStart();
        NetworkInputs weights = neuralNetwork.weights();
        weights.fromFirst();

        while(neuralNetwork.hasNextLayer()) {
            NetworkInputs nextInputs = inputs.makeNew(neuralNetwork.nextLayer());
            nextInputs.fromFirst();

            while(nextInputs.hasNext()) {
                inputs.fromFirst();
                double output = weights.next();
                while(inputs.hasNext()) {
                    output += weights.next() * inputs.next();
                }

                nextInputs.setNext(1/(1 + Math.exp(-output)));
            }

            inputs = nextInputs;
        }

        return inputs;
    }
}
