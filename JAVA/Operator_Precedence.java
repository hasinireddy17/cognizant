public class Operator_Precedence {
    public static void main(String[] args) 
    {
        int x = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2: " + x); 
        System.out.println("Multiplication has higher precedence than addition"); 

        int y = (10 + 5) * 2; 
        System.out.println("Result of (10 + 5) * 2: " + y); 
        System.out.println("Parentheses have the highest precedence");

        int z = 10 - 5 + 2; 
        System.out.println("Result of 10 - 5 + 2: " + z); 
        System.out.println("Operators with the same precedence are evaluated from left to right");
    }
    
}
