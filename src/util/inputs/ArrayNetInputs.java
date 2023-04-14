package util.inputs;

public class ArrayNetInputs implements NetworkInputs {
    double[] inputs;
    int index = -1;
    int marker;

    public ArrayNetInputs(int size) {
        inputs = new double[size];
    }

    @Override
    public void fromFirst() {
        index = -1;
    }

    @Override
    public void write(double val) {
        inputs[index] = val;
    }

    @Override
    public void writeNext(double val) {
        inputs[++index] = val;
    }

    @Override
    public double readNext() {
        return inputs[++index];
    }

    @Override
    public boolean hasNext() {
        return index != inputs.length-1;
    }

    @Override
    public void reset() {
        index = marker;
    }

    @Override
    public void mark() {
        marker = index;
    }

    @Override
    public NetworkInputs makeNew(int size) {
        return new ArrayNetInputs(size);
    }
}
