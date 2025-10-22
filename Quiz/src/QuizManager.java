import java.io.*;
import java.util.*;
import java.util.Scanner;

public class QuizManager {
    private static final String QUIZ_FOLDER = "quizzes";

    //    creating new directory to a fil if id doesn't exist'
    static {
        File folder = new File(QUIZ_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    public static void addQuestionsToQuiz(String quizName) {
        Scanner scanner = new Scanner(System.in);
        File quizFile = new File(QUIZ_FOLDER + "/" + quizName + ".txt");

        int count = 1;
        if (quizFile.exists()) {
            try (BufferedReader r = new BufferedReader(new FileReader(quizFile))) {
                String l;
                while ((l = r.readLine()) != null) {
                    if (l.startsWith("Question ")) {
                        count++;
                    }
                }
            } catch (IOException e) {
                System.out.println("Warning: couldn't read existing file to get question count: " + e.getMessage());
            }
        }
        try (FileWriter writer = new FileWriter(quizFile, true)) {
            System.out.println("If you want to finish writing, type 'exit' as a question.");
            System.out.println("Enter options one by one, with letters (a,b,c,...) added automatically.");
            System.out.println("To finish entering options, press Enter on an empty line.\n");

            while (true) {
                System.out.print("Question " + count + ": ");
                String question = scanner.nextLine();
                if (question.trim().equalsIgnoreCase("exit")) {
                    System.out.println("OK, finished adding questions.");
                    break;
                }
                if (question.trim().isEmpty()) {
                    System.out.println("Empty question, skipping.");
                    continue;
                }
//getting answers
                System.out.println("Enter answer options (press Enter on empty line to finish):");
                List<String> options = new ArrayList<>();
                char letter = 'a';
                while (true) {
                    System.out.print(letter + ") ");
                    String option = scanner.nextLine();
                    if (option.trim().isEmpty()) break;
                    options.add(letter + ") " + option);
                    letter++;
                }

                if (options.isEmpty()) {
                    System.out.println("No options entered, skipping question.");
                    continue;
                }
//right answer
                System.out.print("Enter right answer letter (a, b, c...): ");
                String correctLetter = scanner.nextLine().trim().toLowerCase();

                if (correctLetter.length() != 1 ||
                        correctLetter.charAt(0) < 'a' ||
                        correctLetter.charAt(0) >= 'a' + options.size()) {
                    System.out.println("Invalid answer letter! Saving as 'unknown'.");
                    correctLetter = "unknown";
                }

                writer.write("Question " + count + ": " + question + "\n");
                for (String opt : options) { // исправлено <= на < (иначе ошибка IndexOutOfBounds)
                    writer.write(opt + "\n");
                }
                writer.write("Correct answer: " + correctLetter + "\n");
                writer.write("---\n");

                count++;
            }

        } catch (IOException e) {
            System.out.println("Error while writing in file: " + e.getMessage());
        }
    }

    //    content of a quiz file
    public static void showQuizContent(String quizName) {
        File quizFile = new File(QUIZ_FOLDER + "/" + quizName + ".txt");

        if (!quizFile.exists()) {
            System.out.println("There is no quiz wiht this name");
            return;
        }

        System.out.println("\n Quiz " + quizName + " contains ");
        try (BufferedReader reader = new BufferedReader(new FileReader(quizFile))) { // исправлено создание ридера
            String line;
            while ((line = reader.readLine()) != null) { // исправлено reader.readerLine() → readLine()
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading a file " + e.getMessage());
        }
    }
}
