import java.util.HashMap;
import java.util.Map;

public class FibonacciBottomUpWithMemoization {
    static Map<Integer, Integer> table = new HashMap<>();
    static int numberOfRecursiveCalls = 0;

    static int fibonacci(int n) {
        numberOfRecursiveCalls++;
        Integer memo = table.get(n);
        if (memo != null) return memo;
        if (n == 1 || n == 2) return 1;
        int value = fibonacci(n - 1) + fibonacci(n - 2);
        table.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        table.put(1, 1);
        table.put(2, 1);
        System.out.println(fibonacci(6));
        System.out.println(numberOfRecursiveCalls);
        System.out.println(table);
    }
}
