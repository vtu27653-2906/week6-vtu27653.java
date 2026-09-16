class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> result;

        if (p.length() > s.length())
            return result;

        vector<int> pCount(26, 0);
        vector<int> windowCount(26, 0);

        // Count characters in p
        for (char c : p) {
            pCount[c - 'a']++;
        }

        // Sliding window
        for (int i = 0; i < s.length(); i++) {
            windowCount[s[i] - 'a']++;

            // Remove character outside the window
            if (i >= p.length()) {
                windowCount[s[i - p.length()] - 'a']--;
            }

            // Check when window size == p.length()
            if (i >= p.length() - 1) {
                if (pCount == windowCount) {
                    result.push_back(i - p.length() + 1);
                }
            }
        }

        return result;
    }

output:

Case 1
Case 2
Input
s =
"cbaebabacd"
p =
"abc"
Output
[0,6]
Expected
[0,6]
