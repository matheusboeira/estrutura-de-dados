package entities;

/**
 * Class that represents an array to store Students.
 * 
 * @author Matheus Boeira Dias
 */
public class Vector {
    private static final String MAX_LENGTH = "\nMax length of the vector reached. Nothing added.\n";

    private Student[] students;
    private int length;
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
    public boolean add(Student student) throws Exception {
        if (control > students.length - 1) {
            throw new Exception(MAX_LENGTH);
        }

        if (student != null) {
            students[control++] = student;
            return true;
        }
        return false;
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
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < control; i++) {
            if (students[i] != null) {
                builder.append(String.format("[%d]->", i));
                builder.append(students[i]);
            }
        }
        return builder.toString();
    }
}
