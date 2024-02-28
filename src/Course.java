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

    public Course(String courseCode, String courseName, String professorName, int capacity, int units,
                  int examTimeYear, int examTimeMonth, int examTimeDay, int examTimeHour, int examTimeMinute,
                  int examDuration) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professorName = professorName;
        this.capacity = capacity;
        this.units = units;
        this.examTimeYear = examTimeYear;
        this.examTimeMonth = examTimeMonth;
        this.examTimeDay = examTimeDay;
        this.examTimeHour = examTimeHour;
        this.examTimeMinute = examTimeMinute;
        this.examDuration = examDuration;
        this.rawCapacity=capacity;
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

    public abstract String getType();
}
