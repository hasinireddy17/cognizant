import java.util.Scanner;
public class Number_Guessing {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num=(int)(Math.random()*100)+1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between 1 and 100. Can you guess it?");

        while(true)
        {
            System.out.print("Enter your guess: ");
            int guess=sc.nextInt();

            if(guess<num)
            {
                System.out.println("Too low! Try again.");
            }
            else if(guess>num)
            {
                System.out.println("Too high! Try again.");
            }
            else
            {
                System.out.println("Congratulations! You've guessed the number!");
                break;
            }
        }
    }
}
