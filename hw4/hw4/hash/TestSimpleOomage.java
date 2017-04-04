package hw4.hash;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.HashSet;

public class TestSimpleOomage {

    @Test
    public void testHashCodeDeterministic() {
        SimpleOomage so = SimpleOomage.randomSimpleOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    @Test
    public void testHashCodePerfect() {
        /* TODO: Write a test that ensures the hashCode is perfect,
          meaning no two SimpleOomages should EVER have the same
          hashCode!
         */
        SimpleOomage a = new SimpleOomage(5, 10, 20);
        SimpleOomage a2 = new SimpleOomage(5, 20, 10);
        SimpleOomage a3 = new SimpleOomage(10, 5, 20);
        SimpleOomage a4 = new SimpleOomage(10, 20 ,2);
        SimpleOomage a5 = new SimpleOomage(20, 5, 10);
        SimpleOomage a6 = new SimpleOomage(20, 10, 5);
        assertNotEquals(a, a2);
        assertNotEquals(a, a3);
        assertNotEquals(a, a4);
        assertNotEquals(a, a5);
        assertNotEquals(a, a6);
    }

    @Test
    public void testEquals() {
        SimpleOomage a = new SimpleOomage(5, 10, 20);
        SimpleOomage a2 = new SimpleOomage(5, 10, 20);
        SimpleOomage b = new SimpleOomage(50, 50, 50);
        assertEquals(a, a2);
        assertNotEquals(a, b);
        assertNotEquals(a2, b);
        assertNotEquals(a, "ketchup");
    }

    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleOomage a = new SimpleOomage(5, 10, 20);
        SimpleOomage a2 = new SimpleOomage(5, 10, 20);
        HashSet<SimpleOomage> hashSet = new HashSet<SimpleOomage>();
        hashSet.add(a);
        assertTrue(hashSet.contains(a2));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestSimpleOomage.class);
    }
}
