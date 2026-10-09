
class Solution {
    public int minInsertions(String s) {
        int count = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                need += 2;

                if (need % 2 != 0) {
                    count++;
                    need--;
                }
            } else {
                need--;

                if (need < 0) {
                    count++;
                    need = 1;
                }
            }
        }

        return count + need;
    }
}