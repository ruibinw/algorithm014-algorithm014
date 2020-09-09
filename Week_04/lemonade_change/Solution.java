package lemonade_change;

class Solution1 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                //优先返还大钞票 10
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

//优化代码
class Solution2 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {five--; ten++;}
            //when bill == 20
            else if (ten > 0) {five--; ten--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }
}
