public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int p = 0;
        while (x < 10) {
            
            x = x + 1;
            System.out.print(p + " ");
            p = p + x;
        }
    }
}