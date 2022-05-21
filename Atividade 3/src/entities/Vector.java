package entities;

/**
 * Class that represents an array to store Students.
 * 
 * @author Matheus Boeira Dias
 */
public class Vector implements VectorInterface {
    private Student[] students;
    private int control;

    public Vector() {
        students = new Student[16];
    }

    public Vector(int length) {
        students = new Student[length];
    }

    /**
     * Adds an Student to this vector.
     * 
     * @param student an instance of Student
     * @return true|false
     */
    public boolean add(Student student) {
        if (student != null) {
            incrementSize();
            students[control++] = student;
            return true;
        }
        return false;
    }

    public Student get(int index) {
        if (index > 0 && index < students.length) {
            return students[index];
        }
        throw new IllegalArgumentException("\nIndex out of range.\n");
    }

    /**
     * Checks if this vector reached the end. If yes, then this vector will be
     * copied to a new one with +32 slots.
     */
    public void incrementSize() {
        if (isFull()) {
            Student[] newVector = new Student[size() + 32];

            for (int i = 0, j = 0; i < students.length; i++) {
                if (students[i] != null) {
                    newVector[j++] = students[i];
                }
            }
            students = newVector;
        }
    }

    /**
     * Verifies if this vector contains the given Student.
     * 
     * @param student an intance of an Student to search for
     * @return true|false
     */
    public boolean contains(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == student) {
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
        if (control == students.length) {
            return true;
        }
        return false;
    }

    /**
     * Verifies if this vector contains the given Student and
     * removes from the vector.
     * 
     * @param student an instance of an Student to remove
     * @return true|false
     */
    public boolean remove(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == student) {
                students[i] = null;
                control--;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the number of students in this vector.
     * 
     * @return the number of students
     */
    public int size() {
        return students.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                builder.append(String.format("[%d]->", i));
                builder.append(students[i]);
            }
        }
        return builder.toString();
    }
}
