package ua.org.oa.mrsuperdan;

import java.util.Objects;

public class Student {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 12;
    private static final int MIN_AGE_VALUE = 16;
    private static final int MAX_AGE_VALUE = 70;
    private String name;
    private int age;

    public Student(String name, int age) throws IncorrectPersonParameters {
        setName(name);
        setAge(age);
    }


    public void setName(String name) throws IncorrectPersonParameters {
        if (name.length() > MIN_NAME_LENGTH && name.length() < MAX_NAME_LENGTH) {
            this.name = name;
        } else {
            throw new IncorrectPersonParameters("Name can't be less than " + MIN_NAME_LENGTH + " and more than " + MAX_NAME_LENGTH + " characters");
        }
    }


    public void setAge(int age) throws IncorrectPersonParameters {
        if (age >= MIN_AGE_VALUE && age <= MAX_AGE_VALUE) {
            this.age = age;
        } else {
            throw new IncorrectPersonParameters("Age can't be less than " + MIN_AGE_VALUE + " and more than " + MAX_AGE_VALUE + "years");

        }
    }

    @Override
    public String toString() {
        return "\n" + "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}