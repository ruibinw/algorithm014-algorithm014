package reverse_string;

class Solution {
    public void reverseString(char[] s) {
        if (s == null) return;

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                char tmp = s[i]; s[i] = s[j]; s[j] = tmp;
            }
        }
    }
}
