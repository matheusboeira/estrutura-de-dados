package entities;

/**
 * Class that represents an array to store objects.
 * 
 * @author Matheus Boeira Dias
 */
public class VectorInteger {
    private static final int INITIAL_SIZE = 12;
    private static final int SIZE_TO_INCREMENT = 18;

    private int[] numbers;
    private int size;

    public VectorInteger() {
        numbers = new int[INITIAL_SIZE];
    }

    public VectorInteger(int length) {
        numbers = new int[length];
    }

    /**
     * Adds an element to this vector.
     * 
     * @param element an instance of Object
     * @return true|false
     */
    public void add(int element) {
        incrementSize();
        numbers[size++] = element;
    }

    /**
     * Adds a list of elements to this vector.
     * 
     * @param elements an instance of Object
     * @return true|false
     */
    public void add(int... elements) {
        for (Integer element : elements) {
            add(element);
        }
    }

    /**
     * Get the element in the given index passed.
     * 
     * @param index the position in the vector
     * @return the element in the position
     * @throws Exception if the index is out of bounds
     */
    public int get(int index) throws Exception {
        if (index >= 0 && index < size) {
            return numbers[index];
        }
        throw new Exception("\nIndex out of range.\n");
    }

    /**
     * Checks if this vector reached the end. If yes, then this vector will be
     * copied to a new one with {@code X} slots.
     */
    public void incrementSize() {
        if (isFull()) {
            int[] newVector = new int[size() + SIZE_TO_INCREMENT];

            for (int i = 0; i < numbers.length; i++) {
                newVector[i] = numbers[i];
            }
            numbers = newVector;
        }
    }

    /**
     * Shrink the instance of this vector to the number of elements used. This
     * could be used to free some memory.
     */
    public void shrinkToSize() {
        int[] newVector = new int[size];

        for (int i = 0; i < size; i++) {
            newVector[i] = numbers[i];
        }
        numbers = newVector;
    }

    /**
     * Verifies if this vector contains the given element.
     * 
     * @param element an element to search for
     * @return true|false
     */
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (numbers[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this vector is full.
     * 
     * @return true|false
     */
    public boolean isFull() {
        if (size == numbers.length) {
            return true;
        }
        return false;
    }

    /**
     * Verifies if this vector contains the given element and
     * removes from the vector.
     * 
     * @param element an element to remove
     * @return true|false
     */
    public boolean remove(int element) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (numbers[i] == element) {
                numbers[i] = 0;
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                numbers[i] = numbers[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in this vector.
     * 
     * @return the number of elements
     */
    public int size() {
        return numbers.length;
    }

    /**
     * Sort this vector using bubble sort algorithm.
     */
    public void bubbleSort() {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int aux = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = aux;
                }
            }
        }
    }

    /**
     * Sort this vector using selection sort algorithm.
     */
    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = (i + 1); j < size; j++) {
                if (numbers[i] > numbers[j]) {
                    int auxiliary = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = auxiliary;
                }
            }
        }
    }

    /**
     * Sort this vector using insertion sort algorithm.
     */
    public void insertionSort() {
        for (int i = 1; i < size; i++) {
            int chave = numbers[i];
            int j = i - 1;

            while (j >= 0 && chave < numbers[j]) {
                numbers[j + 1] = numbers[j--];
            }
            numbers[j + 1] = chave;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1) {
                builder.append(String.format("%d, ", numbers[i]));
            } else {
                builder.append(String.format("%d]", numbers[i]));
            }
        }
        return builder.toString();
    }
}