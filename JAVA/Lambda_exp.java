import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class Lambda_exp {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Banana", "Apple", "Mango", "Orange");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println("Sorted names: " + list);
    }
    
}
