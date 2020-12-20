public class CoinChangeTopDownMemoization {

    private static int[] coins = new int[]{10, 6, 1};

    public static int makeChange(int money) {
        int[] cache = new int[money + 1];
        for (int i = 1; i < money + 1; i++)
            cache[i] = -1;
        return makeChange(money, cache);
    }

    static int makeChange(int money, int[] cache) {
        if (cache[money] >= 0) return cache[money];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (money >= coin) {
                int currMinCoins = makeChange(money - coin, cache);
                if (currMinCoins < minCoins)
                    minCoins = currMinCoins;
            }
        }
        cache[money] = minCoins + 1;
        // Add back the coin removed recursively note how head recursion is used

        return cache[money];
    }

    public static void main(String[] args) {
        System.out.println(makeChange(12));
    }
}
