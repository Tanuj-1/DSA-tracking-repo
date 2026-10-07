import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (isValid(current)) {
                ans.add(current);
                found = true;
            }

            // Agar current level par valid mil gaya,
            // to aur characters remove nahi karne hain.
            if (found) {
                continue;
            }

            // Ek-ek parenthesis remove karke next level banao
            for (int i = 0; i < current.length(); i++) {

                char ch = current.charAt(i);

                // Letters ko remove nahi karna
                if (ch != '(' && ch != ')') {
                    continue;
                }

                String next =
                        current.substring(0, i)
                        + current.substring(i + 1);

                if (!visited.contains(next)) {

                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return ans;
    }

    // Check whether parentheses are valid
    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            }

            else if (ch == ')') {

                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}