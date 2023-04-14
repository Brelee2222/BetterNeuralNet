package io.github.brelee2222.mcsurvivalplayer.ai.ml.util.neuralnetwork;

public interface NeuralNetwork {
    public void fromStart();
    public void fromEnd();

    public int nextLayer();
    public int prevLayer();
    public boolean hasNextLayer();
    public boolean hasPrevLayer();

    public double nextWeight();
    public double prevWeight();
    public void setWeight(double newWeight);
}