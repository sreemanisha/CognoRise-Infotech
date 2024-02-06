import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void dropStudent() {
        enrolledStudents--;
    }

    public boolean isFull() {
        return enrolledStudents >= capacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", schedule='" + schedule + '\'' +
                ", enrolledStudents=" + enrolledStudents +
                '}';
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.enrollStudent();
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.dropStudent();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", registeredCourses=" + registeredCourses +
                '}';
    }
}

public class CourseRegistrationSystem {
    private List<Course> courseDatabase;
    private List<Student> studentDatabase;

    public CourseRegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }

    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase) {
            System.out.println(course);
        }
    }

    public void registerStudentForCourse(Student student, Course course) {
        if (!course.isFull()) {
            student.registerCourse(course);
            System.out.println(student.getName() + " has been registered for " + course.getTitle());
        } else {
            System.out.println("Course " + course.getTitle() + " is full. Cannot register " + student.getName());
        }
    }

    public void dropStudentFromCourse(Student student, Course course) {
        if (student.getRegisteredCourses().contains(course)) {
            student.dropCourse(course);
            System.out.println(student.getName() + " has been dropped from " + course.getTitle());
        } else {
            System.out.println(student.getName() + " is not registered for " + course.getTitle());
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        Course course1 = new Course("CSCI101", "Introduction to Computer Science", "Basic concepts of programming", 30, "Mon/Wed/Fri 9:00-10:30");
        Course course2 = new Course("MATH201", "Calculus I", "Limits and derivatives", 25, "Tue/Thu 11:00-12:30");

        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        Student student1 = new Student(1001, "John Doe");
        Student student2 = new Student(1002, "Jane Smith");

        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        registrationSystem.displayCourses();

        registrationSystem.registerStudentForCourse(student1, course1);
        registrationSystem.registerStudentForCourse(student2, course1);

        registrationSystem.registerStudentForCourse(student1, course2);

        registrationSystem.displayCourses();

        registrationSystem.dropStudentFromCourse(student2, course1);

        registrationSystem.displayCourses();
    }
}
