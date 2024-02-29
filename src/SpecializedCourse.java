class SpecializedCourse extends Course {
    private String specialization;

    public SpecializedCourse(String courseCode, String courseName, String professorName, int capacity, int units, int examTimeYear, int examTimeMonth, int examTimeDay, int examTimeHour, int examTimeMinute, int examDuration, int courseWeekDay, int courseHour, int courseMinute, int courseDuration) {
        super(courseCode, courseName, professorName, capacity, units, examTimeYear, examTimeMonth, examTimeDay, examTimeHour, examTimeMinute, examDuration, courseWeekDay, courseHour, courseMinute, courseDuration);
    }


    @Override
    public String getType() {
        return "Specialized";
    }
}