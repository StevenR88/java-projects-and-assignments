package ca.bcit.cst.comp2522.a2;

public class Stack {
    int[] stackValues;
    int count;

    /**
     * Constructor for Stack object.
     * @param arraySize as an int
     */
    public Stack(int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException();
        }
        this.stackValues = new int[arraySize];
    }

    /**
     * Gets the size of the current StackValues array.
     * @return int size of StackValues array
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the number of elements in the stack.
     * @return int as number of elements in stack
     */
    public int size() {
        return count;
    }

    /**
     * Returns the amount of space left in stack.
     * @return int as space remaining in stack
     */
    public int unused() {
        return stackValues.length - count;
    }

    /**
     * Pushes an integer value to the stack.
     * @param value as an int
     */
    public void push(int value) throws StackOverflowException {
        if (stackValues.length - count == 0) {
            throw new StackOverflowException("This stack is full!");
        } else {
            stackValues[count++] = value;
        }
    }

    /**
     * Returns and removes the last value in stack.
     * @return popped stack value as an int
     * @throws StackUnderflowException exception
     */
    public int pop() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.pop() on an empty stack!");
        } else {
            return stackValues[--count];
        }
    }

    /**
     * Returns last value in stack.
     * @return last stack value as an int
     * @throws StackUnderflowException exception
     */
    public int peek() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException(
                    "Cannot call Stack.peek() on an empty stack!");
        }
        return stackValues[count - 1];
    }


}
