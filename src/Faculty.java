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
    
}