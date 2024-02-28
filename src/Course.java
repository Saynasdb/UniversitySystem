import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DayOfWeek;
abstract class Course {
    protected String courseCode;
    protected String courseName;
    protected String professorName;
    protected int rawCapacity;
    protected int capacity;
    protected int units;
    protected int examTimeYear;
    protected int examTimeMonth;
    protected int examTimeDay;
    protected int examTimeHour;
    protected int examTimeMinute;
    protected int examDuration;
    protected int courseWeekDay;
    protected int courseHour;
    protected int courseMinute;
    protected int courseDuration;
    protected DayOfWeek courseDay;
    protected LocalDateTime examDateTime;
    protected LocalTime courseTime;


    public Course(String courseCode, String courseName, String professorName, int rawCapacity, int capacity, int units, int examTimeYear, int examTimeMonth, int examTimeDay, int examTimeHour, int examTimeMinute, int examDuration, int courseWeekDay, int courseHour, int courseMinute, int courseDuration) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professorName = professorName;
        this.rawCapacity = rawCapacity;
        this.capacity = capacity;
        this.units = units;
        this.examTimeYear = examTimeYear;
        this.examTimeMonth = examTimeMonth;
        this.examTimeDay = examTimeDay;
        this.examTimeHour = examTimeHour;
        this.examTimeMinute = examTimeMinute;
        this.examDuration = examDuration;
        this.courseWeekDay = courseWeekDay;
        this.courseHour = courseHour;
        this.courseMinute = courseMinute;
        this.courseDuration = courseDuration;
        this.examDateTime= LocalDateTime.of(examTimeYear,examTimeMonth,examTimeDay,examTimeHour, examTimeMinute);
        this.courseTime= LocalTime.of(courseHour, courseMinute);
        this.courseDay= DayOfWeek.of(courseWeekDay);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessorName() {
        return professorName;
    }

    public int getCapacity() {
        return capacity;
    }
    public int getRawCapacity() {
        return rawCapacity;
    }

    public int getUnits() {
        return units;
    }

    public void decreaseCapacity() {
        if (capacity > 0) {
            capacity--;
        }
    }

    public boolean isAvailable() {
        return capacity > 0;
    }

    public String getExamTime() {
        return examTimeYear + "-" + examTimeMonth + "-" + examTimeDay + " " +
                examTimeHour + ":" + examTimeMinute + " for " + examDuration + " minutes";
    }
    public String getCourseTime() {
        return courseDay + "-" + courseTime + " for " + courseDuration + " minutes";
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public DayOfWeek getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(DayOfWeek courseDay) {
        this.courseDay = courseDay;
    }

    public LocalDateTime getExamDateTime() {
        return examDateTime;
    }

    public void setExamDateTime(LocalDateTime examDateTime) {
        this.examDateTime = examDateTime;
    }

    public void setCourseTime(LocalTime courseTime) {
        this.courseTime = courseTime;
    }

    public abstract String getType();
}
