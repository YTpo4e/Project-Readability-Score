import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EvaluationOfText {
    private File file;
    private double score;
    private double FKScore;
    private double SMOGScore;
    private double GLScore;
    private long characters = 0;
    private long words = 0;
    private int sentences = 0;
    private int syllables = 0;
    private int polysyllables = 0;
    private String text = "";
    public static char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};

    public EvaluationOfText(String path) {
        file = new File(path);
        initText();
        setSentences();
        setWords();
        setCharacters();
        setSyllablesAndSetpolysyllables();
        setScore();

    }

    public void initText() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                text += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read file " + e.getMessage());
        }
    }

    public void printText() {
        System.out.println(text);
    }

    protected void setSentences( ) {
        sentences = text.split("(\\.|!|\\?)").length;
    }

    public int getSentences() {
        return sentences;
    }

    protected void setWords() {
        words = text.split(" ").length;
    }

    public long getWords() {
        return words;
    }

    protected void setCharacters () {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                characters += 1;
            }
        }
    }

    public long getCharacters() {
        return characters;
    }

    public void setScore() {
        score = 4.71 * (characters / (double) words) + 0.5 * (words / (double) sentences) - 21.43;
        FKScore = (0.39 * (words / (double) sentences)) + 11.8 * (syllables / (double) words) - 15.59;
        SMOGScore = 1.043 * Math.sqrt(polysyllables * (30 / (double) sentences)) + 3.1291;
        GLScore = 0.0588 * ((characters / (double) words) * 100) - 0.296 * ((sentences / (double) words) * 100) - 15.8;
    }

    public void setSyllablesAndSetpolysyllables() {
        String[] s = text.split( " ");


        for (int i = 0; i < s.length; i++) {
            int count = 0;
            for (int j = 0; j < s[i].length() - 1; j++) {
                if (isVowel(s[i].toLowerCase().charAt(j)) && !isVowel(s[i].toLowerCase().charAt(j+1))) {
                    syllables += 1;
                    count += 1;
                }
            }
            if (count == 0) {
                syllables += 1;
            }
            if (count > 2) {
                polysyllables += 1;
            }
        }
    }

    public int getSyllables() {
        return syllables;
    }

    public int getPolysyllables() {return polysyllables;}

    public double getScore() {
        return score;
    }

    public double getFKScore() {return  FKScore;}

    public double getSMOGScore() {return SMOGScore;}

    public double getGLScore() {return GLScore;}

    public String estimation(double score) {

        if (score < 2) {
            return " (about 6 year olds).";
        } else if (score < 3) {
            return " (about -7 year olds).";
        } else if (score < 4) {
            return " (about 9 year olds).";
        } else if (score < 5) {
            return " (about 10 year olds).";
        } else if (score < 6) {
            return " (about 11 year olds).";
        } else if (score < 7) {
            return " (about 12 year olds).";
        } else if (score < 8) {
            return " (about 13 year olds).";
        } else if (score < 9) {
            return " (about 14 year olds).";
        } else if (score < 10) {
            return " (about 15 year olds).";
        } else if (score < 11) {
            return " (about 16 year olds).";
        } else if (score < 12) {
            return " (about 17 year olds).";
        } else if (score < 13) {
            return " (about 18 year olds).";
        } else if (score < 14) {
            return " (about 24 year olds).";
        } else if (score >= 14) {
            return " (about 24+ year olds).";
        } else return "incorrect index";
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);

        for (char d : vowels)
        {
            if (c == d)
                return true;
        }
        return false;
    }
}
