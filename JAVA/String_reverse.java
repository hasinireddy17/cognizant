import java.util.Scanner;
public class String_reverse {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        StringBuilder rev=new StringBuilder(str).reverse();
        System.out.println("Reversed string is: " + rev.toString());
    }
}
