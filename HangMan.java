import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HangMan {
    public static void main(String[] args) throws FileNotFoundException {
        //scanner object to read text file of words
        Scanner scanner = new Scanner(new File("C:/JAVA2/JAVA2HANGMANPROJECT/HangMan/hangmanWords.txt"));

        //creating array list to add words
        List<String> HangmanWords = new ArrayList<>();
        //adding words to array list
        while (scanner.hasNext()) {
            HangmanWords.add(scanner.nextLine());
        }

        //create random word object
        Random randomword = new Random();

        //get random words from arraylist
        String word = HangmanWords.get(randomword.nextInt(HangmanWords.size()));

        System.out.println(word);

        List<Character> guesses = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                    if (guesses.contains(word.charAt(i))) {
                        System.out.print(word);
                    } else {
                        System.out.print("_");
                    }
            }
        }
    }




