import java.util.*;

class Solution {
    //sanketvcoder
    public int lengthOfLongestSubstring(String s) {
        List<Character> window = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If character is duplicate, remove from start until no duplicate
            while (window.contains(ch)) {
                window.remove(0);
            }

            window.add(ch);
            maxLen = Math.max(maxLen, window.size());
        }

        return maxLen;
    }
}
