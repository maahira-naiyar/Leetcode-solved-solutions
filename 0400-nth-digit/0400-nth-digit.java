class Solution {
    public int findNthDigit(int n) {
        long start =1;
        long digits =1;
        long count =9;
        while (n > count * digits) {
            n-= count*digits ;
            start *= 10;
            digits ++ ;
            count *= 10;
        }
        start += (n - 1) / digits;
        String num = Long.toString(start);
        return num.charAt((int)((n - 1) % digits)) - '0';
    }
}