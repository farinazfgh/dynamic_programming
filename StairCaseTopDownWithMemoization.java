import java.util.HashMap;
import java.util.Map;

public class StairCaseTopDownWithMemoization {
    static int countWays(int n, Map<Integer, Integer> cache) {
        Integer value = cache.get(n);
        if (value != null) return value;
        if (n == 0) {
            cache.put(0, 1);
            return 1;
        }
        if (n == 1) {
            cache.put(1, 1);
            return 1;
        }
        if (n == 2) {
            cache.put(2, 2);
            return 2;
        }
        Integer temp = countWays(n - 3, cache) + countWays(n - 2, cache) + countWays(n - 1, cache);
        cache.put(n, temp);
        return temp;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();
        System.out.println("(0):" + countWays(0, cache));
        System.out.println("(1):" + countWays(1, cache));
        System.out.println("(2):" + countWays(2, cache));
        System.out.println("(3):" + countWays(3, cache));
        System.out.println("(4):" + countWays(4, cache));
        System.out.println("(5):" + countWays(5, cache));
        System.out.println("(6):" + countWays(6, cache));
    }
}
