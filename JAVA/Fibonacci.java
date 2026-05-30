import java.util.Scanner;
public class Fibonacci {

    public static int fib(int n, int a, int b)
    { 
        if(n==1)
        {
            return a;
        }
        else
        {
            int c=a+b;
            return fib(n-1, b, c);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        int a=0, b=1;
        System.out.println("Fibonacci number is: " + fib(n, a, b));
    }
    
}
