
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        // Store frequency of characters in t
        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int count = t.length();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Character is required
            if (freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            // All required characters are found
            while (count == 0) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                // Window is no longer valid
                if (freq[leftChar] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}
