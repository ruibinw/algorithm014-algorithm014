package string_to_int_atoi;

class Solution {
    public int myAtoi(String s) {
        char[] c = s.toCharArray();
        int i = 0, total = 0, sign = 1;
        //remove space
        while (i < c.length && c[i] == ' ') i++;
        //empty string
        if (i >= c.length) return 0;
        //handle sign
        if (c[i] == '-' || c[i] == '+') {
            sign = s.charAt(i++) == '-' ? -1 : 1;
        }
        //convert number
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = s.charAt(i++) - '0';
            //Integer.MAX_VALUE = 2147483647, Integer.MAX_VALUE/10 = 214748364, Integer.MAX_VALUE%10 = 7,
            if (total > 214748364 || (total == 214748364 && digit > 7))
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            total = total * 10 + digit;
        }
        return total * sign;
    }
}
