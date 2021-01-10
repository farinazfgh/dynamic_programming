public class Test {

    static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int i = 0; i <= capacity; i++) dp[0][i] = profits[0];
        for (int i = 0; i < profits.length; i++) dp[i][0] = 0;
        //base case
        for (int index = 1; index < profits.length; index++)
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                if (weights[index] <= c)
                    profit1 = profits[index] + dp[index - 1][c - weights[index]]; //to include
                int profit2 = dp[index - 1][c]; // to exclude
                dp[index][c] = Math.max(profit1, profit2);
            }
        printdp(dp, profits.length, capacity);
        return dp[profits.length - 1][capacity];
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private static void printdp(int[][] dp, int n, int capacity) {
        for (int i = 0; i < n; i++) {
            for (int c = 0; c <= capacity; c++) {
                System.out.print(dp[i][c] + " , ");
            }
            System.out.println();
        }
    }
}
