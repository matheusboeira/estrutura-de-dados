package entities;

/**
 * Class that represents an array to store objects.
 * 
 * @author Matheus Boeira Dias
 */
public class Vector implements VectorInterface {
    private static final int INITIAL_SIZE = 12;
    private static final int SIZE_TO_INCREMENT = 18;

    private Object[] objects;
    private int control;

    public Vector() {
        objects = new Object[INITIAL_SIZE];
    }

    public Vector(int length) {
        objects = new Object[length];
    }

    /**
     * Adds an Object to this vector.
     * 
     * @param object an instance of Object
     * @return true|false
     */
    public boolean add(Object object) {
        if (object != null) {
            incrementSize();
            objects[control++] = object;
            return true;
        }
        return false;
    }

    /**
     * Get the object in the given index passed.
     * 
     * @param index the position in the vector
     * @return the object in the position
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public Object get(int index) {
        if (index > 0 && index < objects.length) {
            return objects[index];
        }
        throw new IllegalArgumentException("\nIndex out of range.\n");
    }

    /**
     * Checks if this vector reached the end. If yes, then this vector will be
     * copied to a new one with {@code X} slots.
     */
    public void incrementSize() {
        if (isFull()) {
            Object[] newVector = new Object[size() + SIZE_TO_INCREMENT];

            for (int i = 0; i < objects.length; i++) {
                newVector[i] = objects[i];
            }
            objects = newVector;
        }
    }

    /**
     * Shrink the instance of this vector to the number of elements used. This
     * could be used to free some memory.
     */
    public void shrinkToSize() {
        Object[] newVector = new Object[control];

        for (int i = 0; i < control; i++) {
            newVector[i] = objects[i];
        }
        objects = newVector;
    }

    /**
     * Verifies if this vector contains the given Object.
     * 
     * @param object an intance of an Object to search for
     * @return true|false
     */
    public boolean contains(Object object) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == object) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if this vector is full.
     * @return true|false
     */
    public boolean isFull() {
        if (control == objects.length) {
            return true;
        }
        return false;
    }

    /**
     * Verifies if this vector contains the given Object and
     * removes from the vector.
     * 
     * @param Object an instance of an Object to remove
     * @return true|false
     */
    public boolean remove(Object Object) {
        int index = -1;

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == Object) {
                objects[i] = null;
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < objects.length - 1; i++) {
                objects[i] = objects[i + 1];            
            }
            control--;
            return true;  
        }
        return false;
    }

    /**
     * Returns the number of objects in this vector.
     * @return the number of objects
     */
    public int size() {
        return objects.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                builder.append(String.format("[%d]->", i));
                builder.append(objects[i]).append("\n");
            }
        }
        return builder.toString();
    }
}
