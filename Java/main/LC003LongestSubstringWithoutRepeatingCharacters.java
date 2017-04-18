package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC003LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringHashSet(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstringHashMap(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;

    }

    public int lengthOfLongestSubstringSlidingWindow(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int longest = 0;

        for (int i = start; i < chars.length; i++) {
            int findIdx = findchar(chars[i], chars, start, i);
            if (findIdx > -1) {
                int newLength = i - start;
                if (longest < newLength) {
                    longest = newLength;
                }
                start = findIdx + 1;
            }
        }
        if (longest < chars.length - start) {
            longest = chars.length - start;
        }
        return longest;
    }
    private int findchar(char c, char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }


}
