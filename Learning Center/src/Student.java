import java.time.LocalDate;
import java.util.HashMap;
import java.util.Arrays;

public class Student extends Person {
    private int[] grades;
    private HashMap<LocalDate, Boolean> attendance; //

    public Student(int id, String name) {
        super(id, name);
        this.grades = new int[5]; //
        this.attendance = new HashMap<>();
    }

    public void setGrade(int index, int grade) {
        if (index >= 0 && index < grades.length) {
            if (grade >= 2 && grade <= 5)
            grades[index] = grade;
        } else {
            System.out.println("Set grades between 2 and 5");
        }
    }

    public void markAttendance(LocalDate date, boolean isPresent) {
        attendance.put(date, isPresent);
    }

    public double getAverageGrade() {
        return Arrays.stream(grades).average().orElse(0);
    }

    public HashMap<LocalDate, Boolean> getAttendance() {
        return attendance;
    }

    public int[] getGrades() {
        return grades;
    }
}
