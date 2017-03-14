package hw2;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private int t;
    private double[] threshold;
    
    public PercolationStats(int N, int T) {
         if (N < 1 || T < 1) {
             throw new IllegalArgumentException();
         }
         t = T;
         threshold = new double[t];
         
         for (int i = 0; i < threshold.length; i++) {
             threshold[i] = calcthreshold(N);
         }
    } 
    
    private double calcthreshold(int n) {
        double c = 0;
        int i, j;
        Percolation perc = new Percolation(n);
        while (!perc.percolates())
        {
            i = StdRandom.uniform(n)+1;
            j = StdRandom.uniform(n)+1;
            if (!perc.isOpen(i, j))
            {
                c++;
                perc.open(i, j);
            }
        }
        return c / (n*n);
    }
    
    public double mean() {
        
        return StdStats.mean(threshold);
    }
    
    public double stddev() {
        return StdStats.stddev(threshold);
    }
    
    public double confidenceLo() {
        return mean() - (1.96*stddev())/(Math.sqrt(t)); 
    }

    public double confidenceHi() {
        return mean() + (1.96*stddev())/(Math.sqrt(t)); 
    }
    
}

