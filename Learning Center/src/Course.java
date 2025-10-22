import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Course {
    private String courseName;
    private Teacher teacher;
    private List<Student> students;

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Student list for course \"" + courseName + "\":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }

    public void showAttendance() {
        System.out.println("\nAttendance log:");
        for (Student s : students) {
            System.out.println(s.getName() + ": " + s.getAttendance());
        }
    }

    public void showGrades() {
        System.out.println("\nStudent grades:");
        for (Student s : students) {
            System.out.println(s.getName() + " — grades: " + Arrays.toString(s.getGrades()));
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
