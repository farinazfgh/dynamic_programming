public class StairCaseBottomUp {

    static int CountWays(int n) {
        if (n < 2) return 1;
        if (n == 2) return 2;
        int n1 = 1, n2 = 1, n3 = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = temp;
        }
        return n3;
    }

    static int countWays(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(CountWays(3));
        System.out.println(CountWays(4));
        System.out.println(CountWays(5));
    }
}