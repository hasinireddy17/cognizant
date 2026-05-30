import java.util.HashMap;
import java.util.Scanner;
public class HashMap_Ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> students = new HashMap<>();
        
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter student ID:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name:");
            String name = sc.nextLine();
            students.put(id, name);
        }
        System.out.println("Enter student ID to search:");
        int searchId = sc.nextInt();

        if(students.containsKey(searchId)) {
            System.out.println("Student Name: " + students.get(searchId));
        } else {
            System.out.println("Student not found.");
        }


    }
}
