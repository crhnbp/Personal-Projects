import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class TestArrayDeque1B {
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("failed", TestArrayDeque1B.class);
    }   
    @Test
    public void runner() {
        StudentArrayDeque<Integer> bad = new StudentArrayDeque<Integer>(); 
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<Integer>();
        Random xd = new Random();
        int[] seq = new int[50];
        for (int n = 0; n < 50; n += 1) {
            int value = xd.nextInt(6);
            seq[n] = value;
        }
        ops(seq, bad, sol1);
    }
    public void ops(int[] seq, StudentArrayDeque<Integer> sad, ArrayDequeSolution<Integer> sol) {
        String str = "";
        Random ran = new Random();
        for (int i = 0; i < seq.length; i++) {
            if (seq[i] == 0) {
                int num = ran.nextInt(69) + 1;
                sad.addFirst(num);
                sol.addFirst(num);
                str = str + "addFirst(" + num + ")" + "\n";
            }
            if (seq[i] == 1) {
                int num = ran.nextInt(69) + 1;
                sad.addLast(num);
                sol.addLast(num);
                str = str + "addLast(" + num + ")" + "\n";
            }
            if (seq[i] == 2) {
                str = str + "isEmpty()" + "\n";
                boolean x = sol.isEmpty();
                boolean y = sad.isEmpty();
                assertEquals(str, x, y);
            }
            if (seq[i] == 3) {
                str = str + "size()" + "\n";
                Integer x = sol.size();
                Integer y = sad.size();
                assertEquals(str, x, y);
            }
            if (seq[i] == 4) {
                str = str + "removeFirst()" + "\n";
                Integer x = sol.removeFirst();
                Integer y = sad.removeFirst();
                assertEquals(str, x, y);
            }
            if (seq[i] == 5) {
                str = str + "removeLast()" + "\n";
                Integer x = sol.removeLast();
                Integer y = sad.removeLast();
                assertEquals(str, x, y);
            }
            if (seq[i] == 6) {
                int num = ran.nextInt(seq.length - 1);
                str = str + "get(" + num + ")" + "\n";
                Integer x = sol.get(num);
                Integer y = sad.get(num);
                assertEquals(str, x, y);
            }
        }
    }
}
