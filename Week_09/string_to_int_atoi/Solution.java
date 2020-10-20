package string_to_int_atoi;

class Solution {
    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        long total = 0;
        boolean isPlus = true;
        //remove space
        while (i < c.length && c[i] == ' ') i++;
        //empty string
        if (i >= c.length) return 0;
        //handle sign
        if (c[i] == '-' || c[i] == '+')
            isPlus = c[i++] == '+' ? true : false;
        //convert number
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i++] - '0';
            total = total * 10 + digit;
            if (total > Integer.MAX_VALUE)
                return isPlus ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(isPlus ? total : -total);
    }
}
