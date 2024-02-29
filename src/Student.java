import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentNumber;
    private List<Course> registeredCourses = new ArrayList<>();
    private int totalUnits = 0;
    private int generalUnits = 0;
    public static ArrayList<Student> students = new ArrayList<>();

    public Student(String studentNumber) {
        this.studentNumber = studentNumber;
        students.add(this);
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public static Student getStudent(String studentNumber) {
        for (Student student : students) {
            if (student.getStudentNumber().equals(studentNumber)) {
                return student;
            }
        }
        return null;

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
    private  boolean checkCapacity(Course course){
        if(course.getCapacity()>0){
            return true;
        }
        System.out.println("Course " + course.getCourseCode() + " is full.");
        return false;
    }
    private boolean checkUnits(Course course){
        if(course.getUnits()<=21){
            return true;
        }
        System.out.println("Course " + course.getCourseCode() + " exceeds the maximum number of units.");
        return false;
    }
    private boolean checkGeneralUnits(Course course){
        if(course.getType().equals("General") && generalUnits+course.getUnits()<=5){
            return true;
        }
        if(course.getType().equals("General")){
            System.out.println("Course " + course.getCourseCode() + " exceeds the maximum number of general units.");
            return false;
        }
        return false;
    }
    private boolean checkCourse(Course course){
        if(checkCapacity(course) && checkUnits(course) && checkGeneralUnits(course)){
            return true;
        }
        return false;
    }
    private boolean checkExamTimeConflict(Course course1, Course course2){
        if(course1.examDateTime.equals(course2.examDateTime)){
            return true;
        }
        return false;
    }
public void registerCourse(Course course) {

        if (course != null) {
            if(checkCourse(course)){
                for (Course registeredCourse : registeredCourses) {
                    if (checkTimeConflict(registeredCourse, course)) {
                        System.out.println("Course " + course.getCourseCode() + " has time conflict with " + registeredCourse.getCourseCode());
                        return;
                    }
                    if(checkExamTimeConflict(registeredCourse, course)){
                        System.out.println("Course " + course.getCourseCode() + " has exam time conflict with " + registeredCourse.getCourseCode());
                        return;
                    }
                }
                registeredCourses.add(course);
                totalUnits += course.getUnits();
                if (course.getType().equals("General")) {
                    generalUnits += course.getUnits();
                }
                course.decreaseCapacity();
                System.out.println("Course " + course.getCourseCode() + " registered successfully.");
            }else{
                System.out.println("Course " + course.getCourseCode() + " cannot be registered.");
            }
        } else {
            System.out.println("Course " + course.getCourseCode() + " not found.");
        }
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

    public String getStudentName() {
        return  studentNumber;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public int getGeneralUnits() {
        return generalUnits;
    }
}
