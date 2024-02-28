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
    private boolean checkTimeConflict(Course course1, Course course2) {
        //check the day of the week of the course and the time of the course conflict
        if (course1.courseDay.equals(course2.courseDay)) {
            if (course1.courseTime.equals(course2.courseTime)) {
                return true;
            }
        }     return false;

    }
    }