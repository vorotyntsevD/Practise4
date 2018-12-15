package ua.org.oa.mrsuperdan;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Group {

    private final int MIN_AGE_VALUE = 16;
    private final int MAX_AGE_VALUE = 70;
    private ArrayList<Student> group;
    private int counter;


    public Group(int studentsAmount) {
        getGroup(studentsAmount);
    }

    public void getGroup(int studentsAmount) {

        group = new ArrayList<>(studentsAmount);

        Random generate = new Random();

        String[] name = {"Danya", "Petr", "Oleh", "Ivan", "Vova", "Denis", "Nikita", "Sasha", "OJ", "Lu"};

        for (int i = 0; i < studentsAmount; i++) {
            Student student = null;
            try {
                student = new Student(name[generate.nextInt(name.length)], getRandomAge(MIN_AGE_VALUE, MAX_AGE_VALUE));
            } catch (IncorrectPersonParameters e) {
                System.out.println(e.getLocalizedMessage());
            }
            if (student != null) {
                group.add(student);
                counter++;
            }
        }
    }

    private int getRandomAge(int minAge, int maxAge) {
        return (int) ((Math.random() * (maxAge - minAge)) + minAge);
    }

    public void getGroupSize(){
        System.out.println("-----------------");
        System.out.println("В группе: " + counter + " студентов");
    }

    @Override
    public String toString() {
        return "Group{" +
                "group=" + group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group1 = (Group) o;
        return Objects.equals(group, group1.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group);
    }
}