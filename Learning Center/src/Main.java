import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1, "Szoboszlai");
        Course course = new Course("Free kicks", teacher);

        Student s1 = new Student(101, "Mbappe");
        Student s2 = new Student(102, "Ferran");

        course.addStudent(s1);
        course.addStudent(s2);

        // adding grades
        s1.setGrade(0, 5);
        s1.setGrade(1, 4);
        s2.setGrade(0, 2);
        s2.setGrade(1, 3);

        // attendance
        s1.markAttendance(LocalDate.now(), true);
        s2.markAttendance(LocalDate.now(), false);

        // out
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Teacher: " + course.getTeacher().getName());
        course.showStudents();
        course.showGrades();
        course.showAttendance();
    }
}
