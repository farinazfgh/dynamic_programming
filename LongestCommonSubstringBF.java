public class LongestCommonSubstringBF {
    static int findLCSLength(String str1, String str2) {
        int length = 0;
        int index1 = 0;
        int index2 = 0;
        return findLCSLengthRecursive(str1, str2, index1, index2, length);

    }

    private static int findLCSLengthRecursive(String str1, String str2, int index1, int index2, int length) {

        if (index1 == str1.length() || index2 == str2.length()) return length;
        if (str1.charAt(index1) == str2.charAt(index2)) {
            length = findLCSLengthRecursive(str1, str2, index1 + 1, index2 + 1, length + 1);
        }
        return Math.max(length, Math.max(findLCSLengthRecursive(str1, str2, index1 + 1, index2, 0),//they were not equal start over from 0
                findLCSLengthRecursive(str1, str2, index1, index2 + 1, 0)));

    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
