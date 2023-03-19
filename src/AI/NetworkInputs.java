package AI;

public interface NetworkInputs {
    boolean hasNext();
    boolean hasPrev();
    double prev();
    double next();
    void fromLast();
    void fromFirst();
    void setNext(double val);
    void setPrev(double val);
    void set(double val);
    int size();
    void mark();
    void reset();
    NetworkInputs makeNew(int size);
}
