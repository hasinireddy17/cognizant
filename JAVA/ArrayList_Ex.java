import java.util.ArrayList;
import java.util.Scanner;
public class ArrayList_Ex {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> students=new ArrayList<>();
        System.out.println("Enter the number of elements:");    
        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            students.add(sc.nextLine());  
        }
        System.out.println(students);
    }    
}
