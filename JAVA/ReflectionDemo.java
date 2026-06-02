import java.lang.reflect.Method;

class Demo {

    public void greet() {
        System.out.println("Hello Java");
    }
}

public class ReflectionDemo {

    public static void main(String[] args)
            throws Exception {

        Class<?> cls =
                Class.forName("Demo");

        Object obj =
                cls.getDeclaredConstructor()
                        .newInstance();

        Method[] methods =
                cls.getDeclaredMethods();

        for (Method m : methods) {

            System.out.println(
                    "Method: " + m.getName());

            m.invoke(obj);
        }
    }
}