class Solution {
public:
    int strStr(string haystack, string needle) {
        size_t pos = haystack.find(needle);

        if (pos == string::npos)
            return -1;

        return pos;
    }
};


output:

Case 1
Case 2
Input
haystack =
"sadbutsad"
needle =
"sad"
Output
0
Expected
0
