package AI.utils;

public interface NeuralNetwork {
    void fromStart();
    void fromEnd();

    int nextLayer();
    int prevLayer();
    boolean hasNextLayer();
    boolean hasPrevLayer();

    double nextWeight();
    double prevWeight();
    void setWeight(double newWeight);
}
