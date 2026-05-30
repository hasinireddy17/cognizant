public class PatternMatching {

    static void check(Object obj) {

        if (obj instanceof Integer) {
            System.out.println("Integer: " + obj);
        }
        else if (obj instanceof String) {
            System.out.println("String: " + obj);
        }
        else if (obj instanceof Double) {
            System.out.println("Double: " + obj);
        }
        else {
            System.out.println("Unknown Type");
        }
    }

    public static void main(String[] args) {
        check(10);
        check("Java");
        check(5.5);
    }
}