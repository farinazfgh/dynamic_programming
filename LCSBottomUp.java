public class LCSBottomUp {
    static int lcs(String str1, String str2) {
        /*
        The lengths of the two strings will define the size of the array’s two dimensions.
         */
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int index1, index2 = 0;
        int maxLength = 0;
        for (index1 = 1; index1 <= str1.length(); index1++)
            for (index2 = 1; index2 <= str2.length(); index2++) {
                //If the character s1[i] matches s2[j], the length of the common subsequence would be
                // one plus the length of the common subsequence till  the i-1 and j-1 indexes in the two respective strings.
                if (str1.charAt(index1 - 1) == str2.charAt(index2 - 1))
                    dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                else {
                    //we will take the longest subsequence by either skipping ith or jth character from the respective strings.
                    dp[index1][index2] = Math.max(dp[index1][index2 - 1], dp[index1 - 1][index2]);
                }
                maxLength = Math.max(maxLength, dp[index1][index2]);
            }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lcs("abdca", "cbda"));
        System.out.println(lcs("passport", "ppsspt"));
    }
}
