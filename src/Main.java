import AI.*;
import AI.util.CatlystNeuralNetwork;

public class Main {
    public static void main(String[] args) {
        CatlystNeuralNetwork net = new CatlystNeuralNetwork(2, new int[]{2, 2}, 0.1);
        MachineLearning ml = new MachineLearning(net, 0.05);

    }
}
