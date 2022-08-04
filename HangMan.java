import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class HangMan {
    public static void main(String[] args) throws FileNotFoundException {
        //scanner object to read text file of words
        Scanner scanner = new Scanner(new File("C:/JAVA2/JAVA2HANGMANPROJECT/HangMan/hangmanWords.txt"));

        //scanner for guess input
        Scanner input = new Scanner(System.in);

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

        //creating a list of guesses
        List<Character> Guesses = new ArrayList<>();

        //calling printword method
        WordBlanks(word, Guesses);

        System.out.println("enter a letter");

        String guess = input.nextLine();
        //only taking first string of user input
        Guesses.add(guess.charAt(0));

    }

    //method to print a _ for every letter of the word
        private static void WordBlanks(String word, List<Character> Guesses){
            for (int i = 0; i < word.length(); i++) {
                if (Guesses.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }




}




