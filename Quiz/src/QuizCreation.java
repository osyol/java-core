import java.util.Scanner;

public class QuizCreation {
    private static int counter = 1;
    private String name;
    private int id;

    public QuizCreation(String name){
        this.name = name;
        this.id = counter++;
    }

    public void getQuizInfo() {
        System.out.println("Quiz's name is " + name + " and its id: " + id);
    }
}
