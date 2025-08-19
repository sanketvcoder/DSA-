import java.util.*;

class Solution {

    //sanketvcoder
    public List<Character> helper(String digit) {
        Map<String, char[]> m = new HashMap<>();
        m.put("2", new char[]{'a','b','c'});
        m.put("3", new char[]{'d','e','f'});
        m.put("4", new char[]{'g','h','i'});
        m.put("5", new char[]{'j','k','l'});
        m.put("6", new char[]{'m','n','o'});
        m.put("7", new char[]{'p','q','r','s'});
        m.put("8", new char[]{'t','u','v'});
        m.put("9", new char[]{'w','x','y','z'});

        char[] value = m.get(digit);
        if (value == null) {
            return new ArrayList<>();
        }

        List<Character> list = new ArrayList<>();
        for (char c : value) {
            list.add(c);
        }
        return list;
    }

    // Combine all lists of characters into strings (Cartesian product)
    private void backtrack(List<List<Character>> lists, int index, StringBuilder path, List<String> result) {
        if (index == lists.size()) {
            result.add(path.toString());
            return;
        }

        for (Character c : lists.get(index)) {
            path.append(c);
            backtrack(lists, index + 1, path, result);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        // Step 1: Convert digits into list of char lists
        List<List<Character>> newlst = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String d = String.valueOf(digits.charAt(i));
            newlst.add(helper(d));
        }

        // Step 2: Use backtracking to combine
        List<String> result = new ArrayList<>();
        backtrack(newlst, 0, new StringBuilder(), result);
        return result;
    }
}
