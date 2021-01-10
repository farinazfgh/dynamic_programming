public class LCSBF {
    private static int numberofCalls=0;

    //Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence which is common in both the strings.
    static int lcs(String str1, String str2) {
        int index1 = 0, index2 = 0;
        return lcsR(str1, str2, index1, index2);
    }

    static private int lcsR(String str1, String str2, int index1, int index2) {
        numberofCalls++;

        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        if (str1.charAt(index1) == str2.charAt(index2))
            return (1 + lcsR(str1, str2, index1 + 1, index2 + 1));
        int length1 = lcsR(str1, str2, index1 + 1, index2);
        int length2 = lcsR(str1, str2, index1, index2 + 1);
        return Math.max(length1, length2);

    }

    public static void main(String[] args) {
        System.out.println(lcs("abdca", "cbda"));
        System.out.println(lcs("passport", "ppsspt"));
        System.out.println(numberofCalls);
    }
}
