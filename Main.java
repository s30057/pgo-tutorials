import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter your number");
        number = Scanner.nextInt();
        if (number == 0) {
            System.out.println("The value equals 0");
        } else if (number > 0) {
            System.out.println("the number is positive");
        } else {
            System.out.println("The number is negative");
        }
    }
}