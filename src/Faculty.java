import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String facultyName;
    private List<Course> courses = new ArrayList<>();

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    public void removeCourse(String courseCode) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseCode().equals(courseCode)) {
                courses.remove(i);
                System.out.println("Course " + courseCode + " removed successfully.");
                return;
            }
        }
        System.out.println("Course " + courseCode + " not found in faculty " + facultyName);
    }

    public void listCourses() {
        System.out.println("Courses offered by Faculty " + facultyName + ":");
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseName());
        }
    }

    public void listStudentsInCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                System.out.println("Students in Course " + courseCode + " - " + course.getCourseName() + ":");
                // Add functionality to list students here
                return;
            }
        }
        System.out.println("Course " + courseCode + " not found in faculty " + facultyName);
    }
}