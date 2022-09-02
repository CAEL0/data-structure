package recursion;

public class Power {
    public static int power(int x, int n) throws IllegalArgumentException {
        if (n < 0)
            throw new IllegalArgumentException();
        if (n == 0)
            return 1;
        int k = power(x, n / 2);
        if (n % 2 == 1)
            return x * k * k;
        return k * k;
    }
}