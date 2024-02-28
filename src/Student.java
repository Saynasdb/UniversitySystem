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
        }
        return false;

    }
    public void unregisterCourse(String courseCode) {
        for (int i = 0; i < registeredCourses.size(); i++) {
            if (registeredCourses.get(i).getCourseCode().equals(courseCode)) {
                Course course = registeredCourses.remove(i);
                totalUnits -= course.getUnits();
                if (course.getType().equals("General")) {
                    generalUnits -= course.getUnits();
                }
                course.increaseCapacity();
                System.out.println("Course " + courseCode + " unregistered successfully.");
                return;
            }
        }
        System.out.println("Course " + courseCode + " not found in registered courses.");
    }


    public void listRegisteredCourses() {
        System.out.println("Registered Courses for Student " + studentNumber + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }
    }
}
