package util.inputs;
public interface NetworkInputs {
    public void fromFirst();
    public void write(double val);
    public void writeNext(double val);
    public double readNext();
    public boolean hasNext();
    public void reset();
    public void mark();
    public NetworkInputs makeNew(int size);
}
