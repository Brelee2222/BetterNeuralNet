package util.neuralnetwork;

public class DenseNetwork implements NeuralNetwork {
    int[] layerSizes;
    double[] weights;

    int layerIndex;
    int weightIndex;

    public DenseNetwork(int inputs, int[] layerSizes, double randWeights) {
        this.layerSizes = new int[layerSizes.length];

        int totalWeights = 0;
        for(int index = 0; index != layerSizes.length; index++) {
            int layer = this.layerSizes[index] = layerSizes[index];
            totalWeights += inputs * layer + layer;
            inputs = layer;
        }

        this.weights = new double[totalWeights];

        for(int index = 0; index != totalWeights; index++) {
            this.weights[index] = 2 * (Math.random() - 0.5) * randWeights;
        }
    }

    @Override
    public void fromStart() {
        weightIndex = layerIndex = -1;
    }

    @Override
    public void fromEnd() {
        weightIndex = weights.length;
        layerIndex = layerSizes.length;
    }

    @Override
    public int nextLayer() {
        return layerSizes[++layerIndex];
    }

    @Override
    public int prevLayer() {
        return layerSizes[--layerIndex];
    }

    @Override
    public boolean hasNextLayer() {
        return layerIndex != layerSizes.length-1;
    }

    @Override
    public boolean hasPrevLayer() {
        return layerIndex != -1;
    }

    @Override
    public double nextWeight() {
        return weights[++weightIndex];
    }

    @Override
    public double prevWeight() {
        return weights[--weightIndex];
    }

    @Override
    public void setWeight(double newWeight) {
        weights[weightIndex] = newWeight;
    }
}
