import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        EvaluationOfText analize = new EvaluationOfText(args[0]);
        System.out.println("java Main in.txt");
        System.out.println("The text is:");
        analize.printText();
        System.out.println();
        System.out.println("Words: " + analize.getWords());
        System.out.println("Sentences: "  + analize.getSentences());
        System.out.println("Characters: " + analize.getCharacters());
        System.out.println("Syllables: " + analize.getSyllables());
        System.out.println("Polysyllables: " + analize.getPolysyllables());
        choise(analize);
        System.out.println();
    }

    public static void choise(EvaluationOfText ev) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String method = scanner.nextLine();
        System.out.println();
        scanner.close();

        switch (method) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f", ev.getScore());
                System.out.println(ev.estimation(ev.getScore()));
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f", ev.getFKScore());
                System.out.println(ev.estimation(ev.getFKScore()));
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f", ev.getSMOGScore());
                System.out.println(ev.estimation(ev.getSMOGScore()));
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f", ev.getGLScore());
                System.out.println(ev.estimation(ev.getGLScore()));
                break;
            case "all":
                System.out.printf("Automated Readability Index: %.2f", ev.getScore());
                System.out.println(ev.estimation(ev.getScore()));
                System.out.printf("Flesch–Kincaid readability tests: %.2f", ev.getFKScore());
                System.out.println(ev.estimation(ev.getFKScore()));
                System.out.printf("Simple Measure of Gobbledygook: %.2f", ev.getSMOGScore());
                System.out.println(ev.estimation(ev.getSMOGScore()));
                System.out.printf("Coleman–Liau index: %.2f", ev.getGLScore());
                System.out.println(ev.estimation(ev.getGLScore()));
                break;
        }

    }
}