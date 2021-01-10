public class MDI {
    public int findLCSLength(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int lcs = 0;
        int maxLength = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }

    public void findMDI(String s1, String s2) {
        int lcs = findLCSLength(s1, s2);
        System.out.println(s1 + " needs (" + (s1.length() - lcs) + ") deletion and (" + (s2.length() - lcs) + ") insertion to becomes " + s2);
        System.out.println(s2 + " needs (" + (s2.length() - lcs) + ") deletion and (" + (s1.length() - lcs) + ") insertion to becomes " + s1);
    }

    public static void main(String[] args) {
        MDI mdi = new MDI();
        mdi.findMDI("abc", "fbc");
        mdi.findMDI("abdca", "cbda");
        mdi.findMDI("passport", "ppsspt");
    }
}
