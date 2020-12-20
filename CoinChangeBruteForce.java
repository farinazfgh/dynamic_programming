public class CoinChangeBruteForce {
    // Brute force solution. Go through every
    // combination of coins that sum up to c to
    // find the minimum number
   /* Each function calls itself recursively once for each coin. These
    recursive calls are the subproblems because they break down
    our original input into smaller components and calculate those
    respective values.*/
    // Try removing each coin from the total and
    // see how many more coins are required
    static int[] coins = new int[]{10, 6, 1};

    static int makeChange(int money) {
        if (money == 0) return 0;
        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (money >= coin) {

                int currMinCoins = makeChange(money - coin);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
        return minCoins + 1;
        // Add back the coin removed recursively note how head recursion is used
    }

    public static void main(String[] args) {

        System.out.println(makeChange(9));
    }
}
