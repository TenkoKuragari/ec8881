package v3;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        int result = Double.compare(o2.getGpa(), o1.getGpa());
        if (result == 0) {
            return o1.getId() - o2.getId();
        } else {
            return result;
        }
    }
}
