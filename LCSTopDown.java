import java.util.HashMap;
import java.util.Map;

public class LCSTopDown {
    static int numberofCalls = 0;

    //Given two strings ‘s1’ and ‘s2’, find the length of the longest subsequence which is common in both the strings.
    static int lcs(String str1, String str2) {
        int index1 = 0, index2 = 0;
        Map<String, Integer> cache = new HashMap<>();
        return lcsR(str1, str2, index1, index2, cache);
    }

    static private int lcsR(String str1, String str2, int index1, int index2, Map<String, Integer> cache) {
        numberofCalls++;
        if (index1 == str1.length() || index2 == str2.length())
            return 0;
        String key = index1 + "#" + index2;
        if (cache.get(key) != null) return cache.get(key);

        if (str1.charAt(index1) == str2.charAt(index2))
            return (1 + lcsR(str1, str2, index1 + 1, index2 + 1, cache));
        int length1 = lcsR(str1, str2, index1 + 1, index2, cache);
        int length2 = lcsR(str1, str2, index1, index2 + 1, cache);
        int maxLength = Math.max(length1, length2);
        cache.put(key, maxLength);
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println(lcs("abdca", "cbda"));
        System.out.println(lcs("passport", "ppsspt"));
        System.out.println(numberofCalls);

    }
}
