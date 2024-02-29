import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    public void initializeData() {
        // Sample Faculties
        Faculty engineering = new Faculty("Engineering");
        engineering.addCourse(new GeneralCourse("E101", "Introduction to Engineering", "Dr. Ali", 50, 3,
                2024, 3, 10, 9, 0, 90, 1, 10, 30, 90));
        engineering.addCourse(new SpecializedCourse("E201", "Software Engineering", "Dr. Reza", 40, 4,
                2024, 3, 12, 14, 0, 120, 2, 12, 30, 120));
        faculties.add(engineering);

        Faculty science = new Faculty("Science");
        science.addCourse(new GeneralCourse("S101", "Introduction to Biology", "Prof. Zahra", 60, 3,
                2024, 3, 15, 11, 30, 90, 3, 15, 30, 90));
        science.addCourse(new SpecializedCourse("S202", "Organic Chemistry", "Prof. Mohammad", 45, 4,
                2024, 3, 17, 10, 0, 120, 4, 17, 30, 120));
        faculties.add(science);

        // Sample Students
        students.add(new Student("1001"));
        students.add(new Student("1002"));
    }
    public void addFaculty(String facultyName) {
        faculties.add(new Faculty(facultyName));
    }
    public Student addStudent(String studentNumber) {
        Student student = new Student(studentNumber);
        students.add(student);
        return student;
    }



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
