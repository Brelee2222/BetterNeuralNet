package AI;

public interface NetworkInputs {

    /**
     * @return true if there is a next input
     */
    boolean hasNext();

    /**
     * @return the next input of inputs and increments by one
     */
    double next();

    /**
     * @return the prev input, but doesn't increment
     */
    double prev();

    /**
     * starts the inputs at the first input of inputs. pairs with next and hasNext
     */
    void fromFirst();

    /**
     * sets the next input
     */
    void setNext(double val);

    /**
     * sets the current input
     */
    void set(double val);
    /**
     * marks the current position of the input
     */
    void mark();
    /**
     * resets the position to where the mark was placed
     */
    void reset();
    /**
     * Makes a new networkInputs with the given size
     * All NetworkInputs must start as if fromFirst() was called.
     */
    NetworkInputs makeNew(int size);
}
