import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HangMan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:/JAVA2/JAVA2HANGMANPROJECT/hangmanWords.txt"));

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }

    }
}
