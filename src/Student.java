import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentNumber;
    private List<Course> registeredCourses = new ArrayList<>();
    private int totalUnits = 0;
    private int generalUnits = 0;

    public Student(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }
    }