import java.util.HashMap;
import java.util.Map;


public class LongestPalindromicSubsequenceBottomUp {
    static int bruteForceCalls = 0;
    static int memoizedCalls = 0;

    static int lcsBF(String str1, String str2, int index1, int index2, int length) {
        bruteForceCalls++;
        //base case
        if (index1 == str1.length() || index2 == str2.length()) return length;
        if (str1.charAt(index1) == str2.charAt(index2))
            // till now the maximum length is whatever it is, nex round advance one and plus 1
            length = lcsBF(str1, str2, index1 + 1, index2 + 1, length + 1);
        //to inlcude first exclude second
        int value2 = lcsBF(str1, str2, index1, index2 + 1, 0);
        //to exclude first include second
        int value3 = lcsBF(str1, str2, index1 + 1, index2, 0);

        return Math.max(length, Math.max(value2, value3));
    }

    static int lcsTopDown(String str1, String str2) {

        int index1 = 0, index2 = 0, length = 0;

        Map<String, Integer> cache = new HashMap<>();
        return lcsTopDownR(str1, str2, index1, index2, length, cache);
    }

    static private int lcsTopDownR(String str1, String str2, int index1, int index2, int length, Map<String, Integer> cache) {
        memoizedCalls++;
        //base case
        if (index1 == str1.length() || index2 == str2.length()) return 0;
        String key = index1 + "#" + index2 + "#" + length;
        if (cache.get(key) != null) return cache.get(key);
        if (str1.charAt(index1) == str2.charAt(index2))
            length = lcsTopDownR(str1, str2, index1 + 1, index2 + 1, length + 1, cache);

        //to inlcude first exclude second
        int value2 = lcsTopDownR(str1, str2, index1, index2 + 1, 0, cache);
        //to exclude first include second
        int value3 = lcsTopDownR(str1, str2, index1 + 1, index2, 0, cache);
        int currenValue = Math.max(length, Math.max(value2, value3));
        cache.put(key, currenValue);
        return currenValue;
    }

    static int lcsBottomUp(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                maxLength = Math.max(maxLength, dp[i][j]);
                print(dp, str1.length() + 1, str2.length() + 1);
            }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lcsBF("passport", "ppsspt", 0, 0, 0));
        System.out.println(lcsTopDown("passport", "ppsspt"));
        System.out.println(lcsBottomUp("passport", "ppsspt"));
        System.out.println(memoizedCalls + " , " + bruteForceCalls);
        System.out.println(lcsBottomUp("abdca", "cbda"));
        System.out.println(lcsTopDown("abdca", "cbda"));
        System.out.println(lcsBF("abdca", "cbda", 0, 0, 0));

    }

    static void print(int[][] dp, int n, int m) {
        System.out.println("**********************");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " , ");
            }
            System.out.println("");
        }
    }

}
