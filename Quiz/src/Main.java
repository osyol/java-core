import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== QUIZ SYSTEM ===");
            System.out.println("1. Create new quiz");
            System.out.println("2. Add questions to existing quiz");
            System.out.println("3. Show quiz content");
            System.out.println("4. Play quiz");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter quiz name: ");
                    String name = scanner.nextLine();
                    QuizCreation quiz = new QuizCreation(name);
                    quiz.getQuizInfo();
                    break;

                case "2":
                    System.out.print("Enter quiz name to add questions: ");
                    String quizName = scanner.nextLine();
                    QuizManager.addQuestionsToQuiz(quizName);
                    break;

                case "3":
                    System.out.print("Enter quiz name to view content: ");
                    String quizView = scanner.nextLine();
                    QuizManager.showQuizContent(quizView);
                    break;

                case "4":
                    System.out.print("Enter quiz name to play: ");
                    String playQuizName = scanner.nextLine();
                    Player.playQuiz(playQuizName);
                    break;

                case "0":
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
