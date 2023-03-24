package AI;

public class AI {
    NeuralNetwork neuralNetwork;

    public double calculateInput(NetworkInputs inputs) {
        inputs.fromFirst();
        double output = neuralNetwork.nextWeight();
        while(inputs.hasNext()) {
            output += neuralNetwork.nextWeight() * inputs.next();
        }
        return 1/(1 + Math.exp(-output));
    }

    public NetworkInputs get(NetworkInputs inputs) {
        neuralNetwork.fromStart();

        while(neuralNetwork.hasNextLayer()) {
            NetworkInputs nextInputs = inputs.makeNew(neuralNetwork.nextLayer());

            while(nextInputs.hasNext()) {
                nextInputs.setNext(calculateInput(inputs));
            }

            inputs = nextInputs;
        }

        return inputs;
    }
}
