import java.io.*;
import java.util.*;

public class Player {

    public static void playQuiz(String quizName) {
        File quizFile = new File("quizzes/" + quizName + ".txt");

        if (!quizFile.exists()) {
            System.out.println("There is no quiz with this name");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int total = 0; // total number of questions

        try (BufferedReader reader = new BufferedReader(new FileReader(quizFile))) {
            String line;
            String question = null;
            List<String> options = new ArrayList<>();
            String correctAnswer = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Question")) {
                    // if some previous question exists
                    if (question != null && !options.isEmpty() && correctAnswer != null) {
                        total++;
                        askQuestion(scanner, question, options, correctAnswer);
                        if (checkAnswer(scanner, correctAnswer, options)) score++;
                    }

                    // new question
                    question = line.substring(line.indexOf(":") + 1).trim();
                    options.clear();
                    correctAnswer = null;
                } else if (line.matches("^[a-z]\\).*")) {
                    options.add(line.trim());
                } else if (line.startsWith("Correct answer")) {
                    correctAnswer = line.substring(line.indexOf(":") + 1).trim().toLowerCase();
                }
            }

            // last question
            if (question != null && !options.isEmpty() && correctAnswer != null) {
                total++;
                askQuestion(scanner, question, options, correctAnswer);
                if (checkAnswer(scanner, correctAnswer, options)) score++;
            }

            System.out.println("Your score: " + score + "/" + total);

        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    // display questions and answers
    private static void askQuestion(Scanner scanner, String question, List<String> options, String correctAnswer) {
        System.out.println("\n" + question);
        for (String opt : options) {
            System.out.println(opt);
        }
    }

    //checking answer
    private static boolean checkAnswer(Scanner scanner, String correctAnswer, List<String> options) {
        System.out.print("Enter your answer (a, b, c...): ");
        String userAnswer = scanner.nextLine().trim().toLowerCase();

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("✅ Correct!");
            return true;
        } else {
            System.out.println("❌ Wrong! Correct answer was: " + correctAnswer);
            return false;
        }
    }
}
