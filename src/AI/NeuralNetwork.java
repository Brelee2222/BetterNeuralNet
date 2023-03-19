package AI;

public interface NeuralNetwork {
    void fromStart();
    void fromEnd();

    int nextLayer();
    int prevLayer();
    boolean hasNextLayer();
    boolean hasPrevLayer();

    int networkInputs();

    NetworkInputs weights();
}
