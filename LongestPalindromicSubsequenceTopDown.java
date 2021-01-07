public class LongestPalindromicSubsequenceTopDown {
    static int findLPSLength(String st) {
        int startIndex = 0, endIndex = st.length() - 1;
        int[][] cache = new int[st.length()][st.length()];
        return findLPSLengthRecursive(st, startIndex, endIndex, cache);
    }

    private static int findLPSLengthRecursive(String st, int startIndex, int endIndex, int[][] cache) {
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;

        if (cache[startIndex][endIndex] == 0) {
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                cache[startIndex][endIndex] = 2 + findLPSLengthRecursive(st, startIndex + 1, endIndex - 1, cache);
            } else {
                int lenght1 = findLPSLengthRecursive(st, startIndex + 1, endIndex, cache);
                int lenght2 = findLPSLengthRecursive(st, startIndex, endIndex - 1, cache);
                cache[startIndex][endIndex] = Math.max(lenght1, lenght2);
            }
        }
        return cache[startIndex][endIndex];
    }

    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }
}
