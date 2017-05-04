package main;

public class LC009PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int orig = x;
        int y = 0;
        while (x > 0) {
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        return orig == y ;
    }

    public boolean isPalindromeHalf(int x) {
        if (x < 0 ||(x%10==0 && x!=0)) return false;
        int y = 0;
        while (x > y) {
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        return x == y || x == y/10;
    }
}
