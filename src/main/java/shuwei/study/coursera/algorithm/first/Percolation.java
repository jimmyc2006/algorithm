package shuwei.study.coursera.algorithm.first;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
  private final WeightedQuickUnionUF wquf;
  private final WeightedQuickUnionUF wquf2;
  private boolean[][] openStatus;
  private int openCount = 0;
  private final int num;

  private final int top;
  private final int bottom;

  // create n-by-n grid, with all sites blocked
  public Percolation(int n) {
    if(n <1) {
        throw new IllegalArgumentException();
    }
    this.num = n;
    wquf = new WeightedQuickUnionUF(n * n + 2); // n * n + 1 is top; n * n + 2 is floor
    wquf2 = new WeightedQuickUnionUF(n * n + 1);
    top = n * n;
    bottom = n * n + 1;
    for (int i = 1; i <= n; i++) {
      wquf.union(change(1, i), top); // top union to (n * n +1)
      wquf2.union(change(1, i), top);
      if(n > 1) {
          wquf.union(change(n, i), bottom);
      }
    }
    openStatus = new boolean[n + 1][n + 1];
  }

  private int change(int row, int col) {
    return (row - 1) * num + col - 1;
  }

  private void check(int row, int col) {
    check(row);
    check(col);
  }

  private void check(int i) {
    if (i <= 0 || i > num) {
      throw new IllegalArgumentException("row index i out of bounds");
    }
  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    check(row, col);
    if (openStatus[row][col]) {
      return;
    } else {
      openStatus[row][col] = true;
      openCount++;
    }
    int curr = change(row, col);
    if (row > 1 && openStatus[row - 1][col]) {
      wquf.union(curr, change(row - 1, col));
      wquf2.union(curr, change(row - 1, col));
    }
    if (row < num && openStatus[row + 1][col]) {
      wquf.union(curr, change(row + 1, col));
      wquf2.union(curr, change(row + 1, col));
    }
    if (col > 1 && openStatus[row][col - 1]) {
      wquf.union(curr, change(row, col - 1));
      wquf2.union(curr, change(row, col - 1));
    }
    if (col < num && openStatus[row][col + 1]) {
      wquf.union(curr, change(row, col + 1));
      wquf2.union(curr, change(row, col + 1));
    }
  }

  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    check(row, col);
    return openStatus[row][col];
  }

  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    check(row, col);
    return openStatus[row][col] && wquf2.connected(top, change(row, col));
  }

  // number of open sites
  public int numberOfOpenSites() {
    return this.openCount;
  }

  // does the system percolate?
  public boolean percolates() {
    if(num == 1) {
      return openStatus[1][1];
    } else {
      return wquf.connected(top, bottom);
    }
  }
}
