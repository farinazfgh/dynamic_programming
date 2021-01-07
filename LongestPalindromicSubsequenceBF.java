public class LongestPalindromicSubsequenceBF {
    static int findLPSLength(String st) {
        int startIndex = 0, endIndex = st.length() - 1;
        return findLPSLengthRecursive(st, startIndex, endIndex);
    }

    private static int findLPSLengthRecursive(String st, int startIndex, int endIndex) {
        if (startIndex > endIndex) return 0;
        if (startIndex == endIndex) return 1;

        if (st.charAt(startIndex) == st.charAt(endIndex))
            return 2 + findLPSLengthRecursive(st, startIndex + 1, endIndex - 1);
        int length1 = findLPSLengthRecursive(st, startIndex + 1, endIndex);
        int length2 = findLPSLengthRecursive(st, startIndex, endIndex - 1);
        return Math.max(length1, length2);
    }

    public static void main(String[] args) {
        System.out.println(findLPSLength("abdbca"));
        System.out.println(findLPSLength("cddpd"));
        System.out.println(findLPSLength("pqr"));
    }
}
