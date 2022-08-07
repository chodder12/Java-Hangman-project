import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class HangMan {
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

        //creating a list of guesses
        List<Character> Guesses = new ArrayList<>();

        //calling printword method



        //scanner for guess input
        Scanner input = new Scanner(System.in);

        while (true) {
            WordBlanks(word, Guesses);
            UserGuess(input, word, Guesses);


            if (WordBlanks(word, Guesses)){
                System.out.println("you have guessed the full word");
                break;
            }
            System.out.println("would you like to guess the full word");
            input.nextLine();
            if (input.nextLine().equals(word)){
                System.out.println("you have guessed the full word");
                break;
            }
            else{
                System.out.println("that is not the word were looking for");
            }
        }

    }

    private static void UserGuess(Scanner input, String word, List<Character> guesses) {
        System.out.println("Enter letter");

        String guess = input.next();
        //change to only allow one character ********
        guesses.add(guess.charAt(0));
        System.out.println("your guesses are " + guesses);
    }

    //method to print a _ for every letter of the word
        private static boolean WordBlanks(String word, List<Character> Guesses) {
            int correctguesses = 0;
            for (int i = 0; i < word.length(); i++) {
                if (Guesses.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                    correctguesses++;
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
            return (word.length() == correctguesses);
        }




}




