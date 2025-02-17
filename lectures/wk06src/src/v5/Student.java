package v5;

import java.util.Comparator;
import java.util.TreeSet;

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


    public static void main(String[] args) {
//        // anonymous way
//        TreeSet<Student> students = new TreeSet<>(
//                new Comparator<Student>() {
//                    @Override
//                    public int compare(Student o1, Student o2) {
//                        int result = Double.compare(o2.getGpa(), o1.getGpa());
//                        if (result == 0) {
//                            return o1.getId() - o2.getId();
//                        } else {
//                            return result;
//                        }
//                    }
//                }
//        );

        // lambda way
        TreeSet<Student> students = new TreeSet<>(
                (o1, o2) -> {
                    int result = Double.compare(o2.getGpa(), o1.getGpa());
                    if (result == 0) {
                        return o1.getId() - o2.getId();
                    } else {
                        return result;
                    }
                }
        );

        students.add(new Student("Max", 0, 3.9, "CMPE"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("John", 5, 1.8, "SWEN"));
        students.add(new Student("Heather", 3, 3.2, "MATH"));
        students.add(new Student("Finn", 2, 4.0, "CSCI"));
        students.add(new Student("Tyler", 6, 4.0, "CSEC"));
        students.add(new Student("Oldie", 15, 4.0, "AARP"));

        for (Student student : students) {
            System.out.println(student);
        }
    }

}
