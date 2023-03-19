package AI.util;

import AI.NetworkInputs;
import AI.NeuralNetwork;

public class CatlystNeuralNetwork implements NeuralNetwork {
    int layerIndex = -1;

    NetworkInputs weights;

    int[] layers;
    int inputs;
    int networkInputs;
    public CatlystNeuralNetwork(int inputs, int[] layers, double randWeights) {
        this.layers = layers;
        this.inputs = inputs;
        int weightsSize = 0;
        int prevLayer = inputs;
        int networkInputs = prevLayer;
        for(int layer : layers) {
            networkInputs += layer;
            weightsSize += layer + prevLayer * (prevLayer = layer);
        }

        this.networkInputs = networkInputs;
        this.weights = new Weights(weightsSize, randWeights);
    }

    @Override
    public void fromStart() {
        weights.fromFirst();
        layerIndex = -1;
    }

    @Override
    public void fromEnd() {
        weights.fromLast();
        layerIndex = layers.length;
    }

    @Override
    public int nextLayer() {
        return layers[++layerIndex];
    }

    @Override
    public int prevLayer() {
        return layers[--layerIndex];
    }

    @Override
    public boolean hasNextLayer() {
        return layerIndex != layers.length-1;
    }

    @Override
    public boolean hasPrevLayer() {
        return layerIndex != 0;
    }

    @Override
    public int networkInputs() {
        return networkInputs;
    }

    @Override
    public NetworkInputs weights() {
        return weights;
    }

    public class Weights implements NetworkInputs{
        double[] weights;
        int weightIndex = -1;
        int marker = -1;

        public Weights(int weightsSize, double randWeights) {
            weights = new double[weightsSize];

            randWeights *= 2;

            for(int index = 0; index != weights.length; index++) {
                weights[index] = (Math.random() - 0.5) * randWeights;
            }
        }

        @Override
        public boolean hasNext() {
            return weightIndex != weights.length-1;
        }

        @Override
        public boolean hasPrev() {
            return weightIndex != 0;
        }

        @Override
        public double prev() {
            return weights[--weightIndex];
        }

        @Override
        public double next() {
            return weights[++weightIndex];
        }

        @Override
        public void fromLast() {
            weightIndex = weights.length;
        }

        @Override
        public void fromFirst() {
            weightIndex = -1;
        }

        @Override
        public void setNext(double val) {
            weights[++weightIndex] = val;
        }

        @Override
        public void setPrev(double val) {
            weights[--weightIndex] = val;
        }

        @Override
        public void set(double val) {
            weights[weightIndex] = val;
        }

        @Override
        public int size() {
            return weights.length;
        }

        @Override
        public void mark() {
            marker = weightIndex;
        }

        @Override
        public void reset() {
            weightIndex = marker;
        }

        @Override
        public NetworkInputs makeNew(int size) {
            return null;
        }
    }
}
