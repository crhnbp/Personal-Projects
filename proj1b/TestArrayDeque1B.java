import com.sun.imageio.plugins.common.I18N;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArrayDeque1B {

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        for (int i = 0; i < 8; ++i) {
            studentArrayDeque.addFirst(i);
            arrayDequeSolution.addFirst(i);
        }
        for (int i = 7; i != 0; --i) {
            assertEquals(Integer.valueOf(i), arrayDequeSolution.removeFirst());
//            assertEquals(Integer.valueOf(i), studentArrayDeque.removeFirst());
        }
    }

    @Test
    public void testRemoveFirstWithFailureSequence() {
        StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();
        FailureSequence failureSequence = new FailureSequence();
        DequeOperation dequeOperation;
        for (int i = 0; i < 8; ++i) {
            studentArrayDeque.addFirst(i);
            arrayDequeSolution.addFirst(i);
            dequeOperation = new DequeOperation("addFirst", i);
            failureSequence.addOperation(dequeOperation);
        }
        studentArrayDeque.printDeque();
        Integer actual, expected;
        for (int i = 0; i < 8; ++i) {
            actual = studentArrayDeque.removeFirst();
            expected = arrayDequeSolution.removeFirst();
            dequeOperation = new DequeOperation("removeFirst");
            failureSequence.addOperation(dequeOperation);
            assertEquals(failureSequence.toString(), expected, actual);
        }
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", StudentArrayDeque.class);
    }
}
