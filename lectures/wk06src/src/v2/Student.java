package v2;

import java.util.TreeSet;

public class Student implements Comparable<Student> {
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

    public long getId() {
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

//    @Override
//    public boolean equals(Object other) {
//        boolean result = false;
//        if (other instanceof Student) {
//            Student s = (Student) other;
//            result = this.id == s.id;
//        }
//        return result;
//    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Max", 0, 3.9, "CMPE"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("John", 5, 1.8, "SWEN"));
        students.add(new Student("Heather", 3, 3.2, "MATH"));
        students.add(new Student("Finn", 2, 4.0, "CSCI"));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}
