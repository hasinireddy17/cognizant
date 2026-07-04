package JUnit_Excercises;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {

    Student student;

    @Before
    public void setUp() {
        student = new Student("John");
    }

    @After
    public void tearDown() {
        student = null;
    }

    @Test
    public void testStudentName() {
        String expected = "John";
        String actual = student.getName();
        assertEquals(expected, actual);
    }
}