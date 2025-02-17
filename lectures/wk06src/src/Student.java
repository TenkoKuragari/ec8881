
import java.util.TreeSet;
import java.util.function.Consumer;

class StudentPrinter implements Consumer<Student> {

    @Override
    public void accept(Student student) {
        System.out.println(student);
    }
}

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
        TreeSet<Student> students = new TreeSet<>(new StudentComparator());
        students.add(new Student("Max", 0, 3.9, "CMPE"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("Duncan", 1, 3.55, "CSEC"));
        students.add(new Student("John", 5, 1.8, "SWEN"));
        students.add(new Student("Heather", 3, 3.2, "MATH"));
        students.add(new Student("Finn", 2, 4.0, "CSCI"));
        students.add(new Student("Tyler", 6, 4.0, "CSEC"));
        students.add(new Student("Oldie", 15, 4.0, "AARP"));

        students.forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(student);
            }
        });


        // lambda with argument type
        students.forEach((Student student) -> {
            System.out.println(student);
        });

        // lambda without argument type
        students.forEach((student) -> System.out.println(student));

        // method reference
        students.forEach(System.out::println);

        students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .forEach(System.out::println);
    }
}
