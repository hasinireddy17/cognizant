import java.util.Scanner;
public class Palindrome_check {
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string");
        String str=sc.nextLine();
        str=str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int left=0;
        int right=str.length()-1;

        while(left<right){
            if(str.charAt(left)!=str.charAt(right)){
                System.out.println("The string is not a palindrome");
                return;
            }
            left++;
            right--;
        }
        System.out.println("The string is a palindrome");
    }
    
}
