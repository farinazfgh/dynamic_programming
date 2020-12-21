import java.util.HashMap;
import java.util.Map;

public class TargetSumTopDownMemoization {
    // Top down dynamic programming solution. Like
    // 0-1 Knapsack, we use a HashMap to save space
    public int targetSum(int[] numbers, int target) {
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return targetSum(numbers, target, 0, 0, cache);
    }

    // Overloaded recursive function
    private int targetSum(int[] numbers, int target, int i, int sum, Map<Integer, Map<Integer, Integer>> cache) {
        if (i == numbers.length) {
            return sum == target ? 1 : 0;
        }
        if (!cache.containsKey(i)) cache.put(i, new HashMap<>());
        Integer cached = cache.get(i).get(sum);
        if (cached != null) return cached;

        // If we didn't hit in the cache, compute  the value and store to cache
        int toReturn =
                targetSum(numbers, target, i + 1, sum + numbers[i], cache) +
                        targetSum(numbers, target, i + 1, sum - numbers[i], cache);

        cache.get(i).put(sum, toReturn);
        return toReturn;
    }
}
