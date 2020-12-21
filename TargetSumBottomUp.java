public class TargetSumBottomUp {
    static int targetSum(int[] numbers, int target) {
        int sum = 0;
        // Our cache has to range from -sum( numbers) to
        // sum( numbers), so we offset everything by sum
        for (int num : numbers) sum += num;
        int[][] cache = new int[numbers.length + 1][2 * sum + 1];
        if (sum == 0) return 0;
        // Initialize i=0, target=0
        cache[0][sum] = 1;
        for (int i = 1; i <= numbers.length; i++) {
            for (int j = 0; j < 2 * sum + 1; j++) {
                int prev = cache[i - 1][j];
                if (prev != 0) {
                    cache[i][j - numbers[i - 1]] += prev;
                    cache[i][j + numbers[i - 1]] += prev;
                }
                print(cache,numbers.length,2 * sum + 1);
            }
        }
        return cache[numbers.length][sum + target];
    }

    static void print(int[][] cache, int n, int s) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s; j++) {
                System.out.print(cache[i][j] + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(targetSum(numbers, target));
    }
}
