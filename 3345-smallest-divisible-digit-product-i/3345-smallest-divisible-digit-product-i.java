class Solution {
  public int smallestNumber(int n, int t) {
    for (int num = n; num < n + 10; ++num)
      if (getProduct(num) % t == 0)
        return num;
    throw new IllegalArgumentException();
  }

  private int getProduct(int num) {
    int Product = 1;
    while (num > 0) {
      Product *= num % 10;
      num /= 10;
    }
    return Product;
  }
}