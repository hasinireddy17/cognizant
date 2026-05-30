import java.util.Scanner;
public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        switch (operator) {
            case '+':
                System.out.println("Result: " + (num1 + num2));
                break;
                case '-':
                System.out.println("Result: " + (num1 - num2));
                break;
                case '*':
                System.out.println("Result: " + (num1 * num2));
                break;
                case '/':
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
                default:
                    System.out.println("Error: Invalid operator.");
        }
    }  
}
