package entities;

/**
 * Class that represents an student.
 * 
 * @author Matheus Boeira Dias
 */
public class Student {
    private String name;
    private int age;
    private double grade;

    public Student() {}

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    /**
     * @return the name of the student
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age of the student
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the student
     * @param age to set
     */
    public void setAge(int age) {
        if (age > 0 && age < 90) {
            this.age = age;
        }
    }

    /**
     * @return the grade of the student
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the grade of the student
     * @param grade to set
     */
    public void setGrade(double grade) {
        if (grade >= 0 && grade <= 10) {
            this.grade = grade;
        }
    }

    @Override
    public String toString() {
        return String.format("[%s,%d,%.1f]", name, age, grade);
    }
}
