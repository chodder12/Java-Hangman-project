import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.sound.sampled.*;


public abstract class HangMan {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {


        System.out.println("type start and press enter to start your hangman game");
        Scanner sound = new Scanner(System.in);
        //creating background sound
        File file = new File("C://JAVA2//JAVA2HANGMANPROJECT//HangMan//When You're Not Looking - Nathan Moore (1).wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();

        String response = sound.next();





        //scanner object to read text file of words
        Scanner scanner = new Scanner(new File("C:/JAVA2/JAVA2HANGMANPROJECT/HangMan/hangmanWords.txt"));


        //creating array list to add words
        List<String> HangmanWords = new ArrayList<>();
        //adding words to array list
        while (scanner.hasNext()) {
            HangmanWords.add(scanner.nextLine());
        }

        //create random word object
        Random randomWord = new Random();

        //get random words from arraylist
        String word = HangmanWords.get(randomWord.nextInt(HangmanWords.size()));

        //creating a list of guesses
        List<Character> Guesses = new ArrayList<>();


        //scanner for guess input
        Scanner input = new Scanner(System.in);


        int wrongGuesses = 0;
        while (true) {

            printMan(wrongGuesses);

            //ending the game if the user exceeded guesses
            if (wrongGuesses >= 6){
                System.out.println("you couldnt guess the word, you lose");
                System.out.println("your word was " + word);
                break;
            }

            //incrementing wrong guess counter
            WordBlanks(word, Guesses);
            if (!UserGuess(input, word, Guesses)){
                wrongGuesses++;
            }

            //ending game if user guesses entire word
            if (WordBlanks(word, Guesses)){
                System.out.println("you have guessed the full word");
                break;
            }//allowing user to guess full word. guessign full word does not count as wrong guess
            System.out.println("would you like to guess the full word, press enter if you do not have a guess");
            input.nextLine();
            if (input.nextLine().equals(word)){
                System.out.println("you have guessed the full word");
                System.out.println("CONGRATS YOU WIN!!!!");
                break;
            }
            else{
                System.out.println("that is not the word were looking for, try again");
            }
        }

    }

    //creating hangman figure that changes for every wrong answer
    private static void printMan(int wrongGuesses) {
        System.out.println("|      |");

        if (wrongGuesses >= 1) {
            System.out.println(" O");
        }
        if (wrongGuesses >= 2) {
            System.out.print("\\ ");
            if (wrongGuesses >= 3) {
                System.out.println("/");
            }
            else {
                System.out.println("");
            }
        }
        if (wrongGuesses >= 4){
            System.out.println(" |");
        }
        if (wrongGuesses >= 5) {
            System.out.print("/ ");
            if (wrongGuesses >= 6) {
                System.out.println("\\");
            }
            else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }


//taking and printing user guesses. takes only first character of input
    private static boolean UserGuess(Scanner input, String word, List<Character> guesses) {
        System.out.println("Enter letter");

        String guess = input.next();
        //change to only allow one character
        guesses.add(guess.charAt(0));
        System.out.println("your guesses are " + guesses);
        return word.contains(guess);
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