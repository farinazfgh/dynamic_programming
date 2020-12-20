public class CoinChangeBottomUpMemoization {
    private static int[] coins = new int[]{10, 6, 1};

    //Bottom up dynamic programming solution.
    // Iteratively compute number of coins for
    // larger and larger amounts of change
    // Try removing each coin from the total
    // and see which requires the fewest
    // extra coins
    public static int makeChange(int money) {
        int[] cache = new int[money + 1];
        for (int i = 1; i <= money; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    int currCoins = cache[i - coin] + 1;
                    if (currCoins < minCoins) {
                        minCoins = currCoins;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[money];
    }

    public static void main(String[] args) {
        System.out.println(makeChange(12));
    }
}
