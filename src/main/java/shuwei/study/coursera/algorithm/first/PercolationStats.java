package shuwei.study.coursera.algorithm.first;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * @author shuwei
 * @version 创建时间：2018年1月24日 下午6:28:27 类说明
 */
public class PercolationStats {
  private int num;
  private int trials;

  private double[] pts;
  private double mean;
  private double stddev;
  private double confidenceLo;
  private double confidenceHi;

  // perform trials independent experiments on an n-by-n grid
  public PercolationStats(int n, int trials) {
    if (n <= 0 || trials <= 0) {
      throw new IllegalArgumentException();
    }
    this.num = n;
    this.trials = trials;
    doRun();
    calculate();
  }

  private void doRun() {
    pts = new double[trials];
    for (int i = 0; i < trials; i++) {
      Percolation p = new Percolation(num);
      while (!p.percolates()) {
        int row = StdRandom.uniform(num) + 1;
        int col = StdRandom.uniform(num) + 1;
        p.open(row, col);
      }
      pts[i] = 1.0 * p.numberOfOpenSites() / (num * num);
    }
  }

  private void calculate() {
    calculateMean();
    calculateStddev();
    calculateConfidenceLo();
    calculateConfidenceHi();
  }

  private void calculateMean() {
    this.mean = StdStats.mean(pts);
  }

  private void calculateStddev() {
    this.stddev = StdStats.stddev(pts);
  }

  private void calculateConfidenceLo() {
    confidenceLo = this.mean - 1.96 * this.stddev / Math.sqrt(this.trials);
  }

  private void calculateConfidenceHi() {
    this.confidenceHi = this.mean + 1.96 * this.stddev / Math.sqrt(this.trials);
  }

  // sample mean of percolation threshold
  public double mean() {
    return this.mean;
  }

  // sample standard deviation of percolation threshold
  public double stddev() {
    return this.stddev;
  }

  // low endpoint of 95% confidence interval
  public double confidenceLo() {
    return this.confidenceLo;
  }

  // high endpoint of 95% confidence interval
  public double confidenceHi() {
    return this.confidenceHi;
  }

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    PercolationStats ps = new PercolationStats(200, 100);
    long end = System.currentTimeMillis();
    System.out.println("mean = " + ps.mean());
    System.out.println("stddev = " + ps.stddev());
    System.out.println("confidenceLo = " + ps.confidenceLo());
    System.out.println("confidenceHi = " + ps.confidenceHi());
    System.out.println("耗时:" + (end - start));
  }
}
