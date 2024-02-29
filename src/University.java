import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    public Student getStudent(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;
    }

    public Course getCourse(String facultyName, String courseCode) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equalsIgnoreCase(facultyName)) {
                return faculty.getCourse(courseCode);
            }
        }
        return null;
    }

    public void addCourse(String facultyName, Course course) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equalsIgnoreCase(facultyName)) {
                faculty.addCourse(course);
                System.out.println("Course added to " + facultyName + " successfully.");
                return;
            }
        }
        System.out.println("Faculty " + facultyName + " not found.");
    }

    public void removeCourse(String facultyName, String courseCode) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equalsIgnoreCase(facultyName)) {
                faculty.removeCourse(courseCode);
                return;
            }
        }
        System.out.println("Course " + courseCode + " not found in " + facultyName);
    }

    public void listFaculties() {
        System.out.println("List of Faculties:");
        for (Faculty faculty : faculties) {
            System.out.println(faculty.getFacultyName());
        }
    }

    public void listCoursesByFaculty(String facultyName) {
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyName().equalsIgnoreCase(facultyName)) {
                faculty.listCourses();
                return;
            }
        }
        System.out.println("Faculty " + facultyName + " not found.");
    }
}
