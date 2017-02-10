import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class TestArrayDeque1B {
    @Test
    public void testoperations() {
        StudentArrayDeque<Integer> bad = new StudentArrayDeque<Integer>(); 
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<Integer>();
        int [] seq = new int[60];
        Random rn = new Random();
        for (int n = 0; n < 60; n++) {
            int val = rn.nextInt(6);
            seq[n] = val;
        }
        ops(seq, bad, sol1);
    }
    public void ops(int [] seq, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> sol) {
        Random ran = new Random();
        String fs = "";
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == 0) {
                int num = ran.nextInt(60) + 1;
                sad.addFirst(num);
                sol.addFirst(num);
                fs = fs + "addFirst(" + num + ")" + "\n";
            }
            if (seq[i] == 1) {
                int num = ran.nextInt(60) + 1;
                sad.addLast(num);
                sol.addLast(num);
                fs = fs + "addLast(" + num + ")" + "\n";
            }
            if (seq[i] == 2) {
                fs = fs + "isEmpty()" + "\n";
                boolean x = sol.isEmpty();
                boolean y = sad.isEmpty();
                assertEquals(fs, x, y);
            }
            if (seq[i] == 3) {
                fs = fs + "size()" + "\n";
                Integer x = sol.size();
                Integer y = sad.size();
                assertEquals(fs, x, y);
            }
            if (seq[i] == 4) {
                fs = fs + "removeFirst()" + "\n";
                Integer x = sol.removeFirst();
                Integer y = sad.removeFirst();
                assertEquals(fs, x, y);
            }
            if (seq[i] == 5) {
                fs = fs + "removeLast()" + "\n";
                Integer x = sol.removeLast();
                Integer y = sad.removeLast();
                assertEquals(fs, x, y);
            }
            if (seq[i] == 6) {
                int num = ran.nextInt(seq.length - 1);
                fs = fs + "get(" + num + ")" + "\n";
                Integer x = sol.get(num);
                Integer y = sad.get(num);
                assertEquals(fs, x, y);
            }
        }
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("failed", TestArrayDeque1B.class);
    }   
}
