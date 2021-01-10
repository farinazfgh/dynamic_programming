import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubstringTopDown {

    //Given two strings ‘s1’ and ‘s2’, find the length of the longest substring which is common in both the strings.
    static int findLCSLength(String str1, String str2) {
        int length = 0;
        int index1 = 0, index2 = 0;
        Map<String, Integer> cache = new HashMap<>();
        return findLCSLengthRecursive(str1, str2, index1, index2, length, cache);

    }

    private static int findLCSLengthRecursive(String str1, String str2, int index1, int index2, int length, Map<String, Integer> cache) {

        if (index1 == str1.length() || index2 == str2.length()) return length;
        String key = index1 + "#" + index2 + "#" + length;

        if (cache.get(key) == null) {
            int lenght1 = length;
            if (str1.charAt(index1) == str2.charAt(index2)) {
                lenght1 = findLCSLengthRecursive(str1, str2, index1 + 1, index2 + 1, length + 1, cache);
            }
            int length2 = findLCSLengthRecursive(str1, str2, index1 + 1, index2, 0, cache);
            int length3 = findLCSLengthRecursive(str1, str2, index1, index2 + 1, 0, cache);//they were not equal start over from 0
            cache.put(key, Math.max(lenght1, Math.max(length2, length3)));
        }
        return cache.get(key);
    }

    public static void main(String[] args) {
        System.out.println(findLCSLength("abdca", "cbda"));
        System.out.println(findLCSLength("passport", "ppsspt"));
    }
}
