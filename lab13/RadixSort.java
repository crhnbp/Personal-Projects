/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra
 * @version 1.4 - April 14, 2016
 *
 **/
public class RadixSort {

    private static final int R = 256;   
    private static final int CUTOFF = 15;

    /**
     * Does Radix sort on the passed in array with the following restrictions:
     *  The array can only have ASCII Strings (sequence of 1 byte characters)
     *  The sorting is stable and non-destructive
     *  The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     **/
    public static String[] sort(String[] asciis) {
        int N = asciis.length;
        if (N == 0 || N == 1) {
            return asciis;
        }
        String[] sorted = new String[N];
        for (int i = 0; i < N; i++) {
            sorted[i] = asciis[i];
        }
        String[] aux = new String[N];
        sortHelper(sorted, 0, N - 1, 0, aux);
        return sorted;
    }
    

    /**
     * Radix sort helper function that recursively calls itself to achieve the sorted array
     *  destructive method that changes the passed in array, asciis
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }

    // sort from a[lo] to a[hi], starting at the dth character
    private static void sortHelper(String[] a, int lo, int hi, int d, String[] aux) {

        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];
        for (int r = 0; r < R; r++)
            sortHelper(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
    }


    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
}
