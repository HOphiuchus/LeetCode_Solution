package main;

public class LC007ReverseInteger {
    public int reverse(int x) {
        long target = 0;
        for (int i = x; i != 0; i /= 10) {
            target = target * 10 + i % 10;
            if (target > Integer.MAX_VALUE || target < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) target;
    }
}
