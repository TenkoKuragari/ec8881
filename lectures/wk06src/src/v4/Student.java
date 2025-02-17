package v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

public class Student {
    private String name;
    private int id;
    private double gpa;
    private String major;

    public Student(String name, int id, double gpa, String major) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                '}';
    }

    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Student) {
            Student s = (Student) other;
            result = this.id == s.id;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public static void main(String[] args) {
        HashMap<Student, String> students = new HashMap<>();

        students.put(new Student("Max", 0, 3.9, "CMPE"), "EVIL");
        students.put(new Student("Duncan", 1, 3.55, "CSEC"), "CHAOTIC");
        students.put(new Student("John", 5, 1.8, "SWEN"), "GOOD");
        students.put(new Student("Heather", 3, 3.2, "MATH"), "NEUTRAL");
        students.put(new Student("Finn", 2, 4.0, "CSCI"), "LAWFUL");

        System.out.println(students.get(new Student("Max", 0, 3.9, "CMPE")));


    }
}

