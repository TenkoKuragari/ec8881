package lambda;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int result = o2.getGpa() - o1.getGpa();
    }
}
