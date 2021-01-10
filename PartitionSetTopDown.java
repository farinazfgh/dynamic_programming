import java.util.HashMap;
import java.util.Map;

public class PartitionSetTopDown {
    static int numberOfRecursiveCalls = 0;

    /*
    varried version of knapsack "Find a subset of the given numbers that has a total sum of sum/2".
     */
    static boolean canPartition(int[] num) {
        int sum = 0, index = 0;
        for (int value : num) sum += value;
        double mod = sum % 2;
        if (mod != 0) return false;// if 'sum' is a an odd number, we can't have two subsets with equal sum
        Map<String, Boolean> cache = new HashMap<>();

        return canPartitionR(num, index, (sum / 2), cache);
    }

    private static boolean canPartitionR(int[] num, int index, int sum, Map<String, Boolean> cache) {
        numberOfRecursiveCalls++;
        //base case
        if (sum == 0) return true;
        if (num.length == 0 || index > num.length - 1) return false;
        /*
        recursive call after choosing the number at the currentIndex
        if the number at currentIndex exceeds the sum, we shouldn't process this*/
        String key = index + "#" + sum;
        if (cache.get(key) == null) {
            if (num[index] <= sum && canPartitionR(num, index + 1, sum - num[index], cache)) {                //to include
                cache.put(key, true);
                return true;
            }
            //to exclude
            cache.put(key, canPartitionR(num, index + 1, sum, cache));
            // recursive call after excluding the number at the currentIndex
        }
        return cache.get(key);
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
        System.out.println(numberOfRecursiveCalls);
    }
}
