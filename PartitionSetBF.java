
public class PartitionSetBF {
    /*
    varried version of knapsack "Find a subset of the given numbers that has a total sum of sum/2".
     */
    static boolean canPartition(int[] num) {
        int sum = 0, index = 0;
        for (int value : num) sum += value;
        double mod = sum % 2;
        if (mod != 0) return false;// if 'sum' is a an odd number, we can't have two subsets with equal sum
        return canPartitionR(num, index, (sum / 2));
    }

    private static boolean canPartitionR(int[] num, int index, int sum) {
        //base case
        if (sum == 0) return true;
        if (num.length == 0 || index > num.length - 1) return false;
        /*
        recursive call after choosing the number at the currentIndex
        if the number at currentIndex exceeds the sum, we shouldn't process this*/
        if (num[index] <= sum) {
            //to include
            if (canPartitionR(num, index + 1, sum - num[index])) return true;
        }
        //to exclude
        return canPartitionR(num, index + 1, sum);
        // recursive call after excluding the number at the currentIndex
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(canPartition(num));
    }
}
