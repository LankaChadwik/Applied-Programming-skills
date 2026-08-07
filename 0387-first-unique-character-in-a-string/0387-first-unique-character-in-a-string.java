class Solution {
    public int firstUniqChar(String s) {
        // Frequency array for lowercase English letters (26 characters)
        int[] count = new int[26];
        
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        // Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // If no non-repeating character exists
        return -1;
    }
}