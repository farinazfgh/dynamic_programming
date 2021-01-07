public class LongestCommonSubstringTopDown {

    static int findLCSLength(String str1, String str2) {
        int length = 0;
        int index1 = 0, index2 = 0;
        int maxLength = Math.max(str1.length(), str2.length());
        int[][][] cache = new int[str1.length()][str2.length()][maxLength];
        return findLCSLengthRecursive(str1, str2, index1, index2, length, cache);

    }

    private static int findLCSLengthRecursive(String str1, String str2, int index1, int index2, int length, int[][][] cache) {

        if (index1 == str1.length() || index2 == str2.length()) return length;
        if (cache[index1][index2][length] == 0) {
            int lenght1 = length;
            if (str1.charAt(index1) == str2.charAt(index2)) {
                lenght1 = findLCSLengthRecursive(str1, str2, index1 + 1, index2 + 1, length + 1, cache);
            }
            int length2 = findLCSLengthRecursive(str1, str2, index1 + 1, index2, 0, cache);
            int length3 = findLCSLengthRecursive(str1, str2, index1, index2 + 1, 0, cache);//they were not equal start over from 0
            cache[index1][index2][length] = Math.max(lenght1, Math.max(length2, length3));
        }
        return cache[index1][index2][length];
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
