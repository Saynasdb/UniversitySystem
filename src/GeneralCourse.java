class GeneralCourse extends Course {
    public GeneralCourse(String courseCode, String courseName, String professorName, int capacity, int units,
                         int examTimeYear, int examTimeMonth, int examTimeDay, int examTimeHour, int examTimeMinute,
                         int examDuration) {
        super(courseCode, courseName, professorName, capacity, units, examTimeYear, examTimeMonth, examTimeDay,
                examTimeHour, examTimeMinute, examDuration);
    }

    @Override
    public String getType() {
        return "General";
    }
}