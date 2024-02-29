import java.util.Scanner;

public class UniversitySystem {
    public static void main(String[] args) {

        University university = new University();
        university.initializeData();  // Initialize with sample faculties and courses

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {
            System.out.println("\nWelcome to University Management System");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Number: ");
                    String studentNumber = scanner.nextLine();
                    Student student = university.getStudent(studentNumber);
                    if (student != null) {
                        studentMenu(university,student, scanner);
                    } else {
                        System.out.println("Student not found.Making new Student...");
                        student=university.addStudent(studentNumber);
                        studentMenu(university,student, scanner);
                    }
                    break;
                case 2:
                    System.out.print("Enter Admin Username (e.g., Admin): ");
                    String adminUsername = scanner.nextLine();
                    if (adminUsername.equalsIgnoreCase("Admin")) {
                        adminMenu(university, scanner);
                    } else {
                        System.out.println("Invalid Admin Username.");
                    }
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();

    }
    private static void studentMenu(University university, Student student, Scanner scanner) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\nStudent Menu");
            System.out.println("1. View Registered Courses");
            System.out.println("2. View Courses Offered by Faculty");
            System.out.println("3. Register for a Course");
            System.out.println("4. Unregister from a Course");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    student.listRegisteredCourses();
                    break;
                case 2:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    break;
                case 3:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    System.out.print("Enter Course Code to Register: ");
                    String courseCodeToRegister = scanner.nextLine();
                    student.registerCourse(university.getCourse(facultyName, courseCodeToRegister));
                    break;
                case 4:
                    System.out.print("Enter Course Code to Unregister: ");
                    String courseCodeToUnregister = scanner.nextLine();
                    student.unregisterCourse(courseCodeToUnregister);
                    break;
                case 5:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void adminMenu(University university, Scanner scanner) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. View Courses Offered by Faculty");
            System.out.println("2. Add a New Course");
            System.out.println("3. Remove a Course");
            System.out.println("4. View Students in a Course");
            System.out.println("5. Add Student to a Course");
            System.out.println("6. Remove Student from a Course");
            System.out.println("7. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    String facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    break;
                case 2:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name to Add Course: ");
                    facultyName = scanner.nextLine();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Professor Name: ");
                    String professorName = scanner.nextLine();
                    System.out.print("Enter Course Capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter Course Units: ");
                    int units = scanner.nextInt();
                    System.out.println("Enter Course Time (WeekDay Hour Minute Duration): ");
                    int courseWeekDay = scanner.nextInt();
                    int courseHour = scanner.nextInt();
                    int courseMinute = scanner.nextInt();
                    int courseDuration = scanner.nextInt();


                    System.out.print("Enter Exam Time (Year Month Day Hour Minute Duration): ");
                    int examTimeYear = scanner.nextInt();
                    int examTimeMonth = scanner.nextInt();
                    int examTimeDay = scanner.nextInt();
                    int examTimeHour = scanner.nextInt();
                    int examTimeMinute = scanner.nextInt();
                    int examDuration = scanner.nextInt();
                    System.out.println();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter Course Type (General/Specialized): ");
                    String courseType = scanner.nextLine();

                    Course newCourse;
                    if (courseType.equalsIgnoreCase("General")) {
                        newCourse = new GeneralCourse(courseCode, courseName, professorName, capacity, units,
                                examTimeYear, examTimeMonth, examTimeDay, examTimeHour, examTimeMinute, examDuration, courseWeekDay, courseHour, courseMinute, courseDuration);
                    } else if (courseType.equalsIgnoreCase("Specialized")) {
                        System.out.print("Enter Specialization: ");
                        String specialization = scanner.nextLine();
                        newCourse = new SpecializedCourse(courseCode, courseName, professorName, capacity, units,
                                examTimeYear, examTimeMonth, examTimeDay, examTimeHour, examTimeMinute, examDuration, courseWeekDay, courseHour, courseMinute, courseDuration);
                    } else {
                        System.out.println("Invalid Course Type.");
                        break;
                    }

                    university.addCourse(facultyName, newCourse);
                    break;
                case 3:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name to Remove Course: ");
                    facultyName = scanner.nextLine();
                    System.out.print("Enter Course Code to Remove: ");
                    courseCode = scanner.nextLine();
                    university.removeCourse(facultyName, courseCode);
                    break;
                case 4:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    university.listStudentsInCourse(facultyName, courseCode);
                    break;
                case 5:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    System.out.print("Enter Student Number to Add: ");
                    String studentNumberToAdd = scanner.nextLine();
                    university.addStudentToCourse(facultyName, courseCode, studentNumberToAdd);
                    break;
                case 6:
                    university.listFaculties();
                    System.out.print("Enter Faculty Name: ");
                    facultyName = scanner.nextLine();
                    university.listCoursesByFaculty(facultyName);
                    System.out.print("Enter Course Code: ");
                    courseCode = scanner.nextLine();
                    System.out.print("Enter Student Number to Remove: ");
                    String studentNumberToRemove = scanner.nextLine();
                    university.removeStudentFromCourse(facultyName, courseCode, studentNumberToRemove);
                    break;
                case 7:
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}