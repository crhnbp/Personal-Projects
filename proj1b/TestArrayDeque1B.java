import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;
public class TestArrayDeque1B {
    @Test
    public void testAddFirst(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i = 0;i<10; i++){
            int rnd = rn.nextInt();
            student.addFirst(rnd);
            solution.addFirst(rnd);
        }
        for(int i = 0;i<10; i++){
            assertEquals(student.get(i), solution.get(i));
        }

    }
    @Test
    public void testAddLast(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i = 0;i<10;i++){
            int rnd = rn.nextInt();
            student.addLast(rnd);
            solution.addLast(rnd);
        }
        for(int i =0;i<10;i++){
            assertEquals(student.get(i), solution.get(i));
        }
    }
    @Test
    public void testRemoveFirst(){
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        Random rn = new Random();
        for(int i =0;i<10;i++){
            int rnd = rn.nextInt();
            student.addFirst(rnd);
            solution.addFirst(rnd);

        }
        for(int i = 0;i<10; i++){
            assertEquals(student.removeFirst(),solution.removeFirst());
        }
    }
    @Test
    public void testRemoveLast(){
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        /*test empty case*/
        assertEquals(null, sad.removeLast());

        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        sad1.addLast(1);
        sad1.addLast(2);
        sad1.addLast(3);
        int removedItem = sad1.removeLast();
        assertEquals(3, removedItem);
        StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<>();
        sad2.addLast(1);
        sad2.addLast(2);
        sad1.printDeque();
    }

    }


