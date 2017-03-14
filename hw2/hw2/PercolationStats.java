package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    
    private static double[] num;
    private int x;
    
    public PercolationStats(int N, int T) {
        if (N <= 0) {
            throw new IllegalArgumentException(N + " is not positive.");
        }
        if (T <= 0) {
            throw new IllegalArgumentException(T + " is not positive.");
        }
        num = new double[T];
        x = T;
        for (int i = 0; i < T; i += 1) {
            Percolation perc = new Percolation(N);
            int count = 0;
            while (count < N * N * N) {
                int j = StdRandom.uniform(N);
                int k = StdRandom.uniform(N);
                perc.open(j, k);
                if (perc.percolates()) {
                    num[i] = ((double) perc.numberOfOpenSites()) / (N * N);
                    break;
                }
                count += 1;
            }
        }
    }
    public double mean() {
        return StdStats.mean(num);
    }
    public double stddev() {
        return StdStats.stddev(num);
    }
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(x);
    }
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(x);
    }
    public static void main(String[] args) {
    }
}                 
