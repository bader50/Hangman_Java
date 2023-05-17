import java.util.Arrays;
import java.util.Scanner;

public class Hangman {

    public static String[] words = { "ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra" };

    public static String[] gallows = { "+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + // if you were wondering, the only way to print '\' is with a trailing escape
                                  // character, which also happens to be '\'
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n" };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean found = false;
        short count = 0;

        int randomWordNum = (int) (Math.random() * words.length);

        char[] wordToDiscover = new char[words[randomWordNum].length()];
        char[] missed = new char[6];

        System.out.println("word to discover: " + words[randomWordNum]);

        for (int i = 0; i < wordToDiscover.length; i++) {
            wordToDiscover[i] = '_';
        }

        char in = ' ';
        boolean increment;

        while (!found) {

            increment = true;

            System.out.println("Guess:\t" + in);

            System.out.println(gallows[count]);

            System.out.print("Word:\t");

            for (int i = 0; i < wordToDiscover.length; i++) {
                System.out.print(wordToDiscover[i] + " ");
            }

            System.out.println();

            System.out.print("Misses:\t");

            for (int i = 0; i < missed.length; i++) {
                System.out.print(missed[i] + " ");
            }

            System.out.println();

            if (!Arrays.toString(wordToDiscover).contains("_")) {
                System.out.println("Congratulation !");
                break;
            }

            System.out.print("Guess:\t");

            in = sc.nextLine().charAt(0);

            for (int i = 0; i < wordToDiscover.length; i++) {
                if (wordToDiscover[i] == '_') {
                    if (words[randomWordNum].charAt(i) == in) {
                        increment = false;
                        wordToDiscover[i] = in;
                        break;
                    }
                }
            }

            if (increment) {
                missed[count] = in;
                count++;
                if (count >= 6) {
                    found = true;
                    System.out.println("LOST !");
                }
            }
        }

        sc.close();

    }

}
