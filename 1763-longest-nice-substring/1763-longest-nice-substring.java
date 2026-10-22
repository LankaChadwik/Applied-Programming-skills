class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] chars = s.toCharArray();
        java.util.Set<Character> set = new java.util.HashSet<>();
        for (char c : chars) {
            set.add(c);
        }
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (set.contains(Character.toLowerCase(c)) && set.contains(Character.toUpperCase(c))) {
                continue;
            }
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}