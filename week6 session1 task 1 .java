import java.io.*;
import java.util.*;

public class Solution {

    static long similarity(String s) {
        int n = s.length();
        int[] z = new int[n];

        z[0] = n;

        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }

            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }

            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }

        long sum = 0;
        for (int value : z) {
            sum += value;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder out = new StringBuilder();

        while (t-- > 0) {
            String s = br.readLine().trim();
            out.append(similarity(s)).append('\n');
        }

        System.out.print(out);
    }
}


OUTPUT:


Input (stdin)
2
ababaa
aa
Your Output (stdout)
11
3
Expected Output
11
3