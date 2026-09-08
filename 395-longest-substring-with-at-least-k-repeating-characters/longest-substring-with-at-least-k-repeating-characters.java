class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] count = new int[26];
            int left = 0, right = 0;
            int unique = 0, countAtLeastK = 0;

            while (right < n) {
                if (unique <= targetUnique) {
                    int idx = s.charAt(right) - 'a';
                    if (count[idx] == 0) unique++;
                    count[idx]++;
                    if (count[idx] == k) countAtLeastK++;
                    right++;
                } else {
                    int idx = s.charAt(left) - 'a';
                    if (count[idx] == k) countAtLeastK--;
                    count[idx]--;
                    if (count[idx] == 0) unique--;
                    left++;
                }

                if (unique == targetUnique && unique == countAtLeastK) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }

        return maxLen;
    }
}