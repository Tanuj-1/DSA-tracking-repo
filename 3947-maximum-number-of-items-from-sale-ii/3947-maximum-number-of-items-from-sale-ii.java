import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        // Step 1: Find minimum price
        int minPrice = Integer.MAX_VALUE;

        // Count frequency of each factor
        int[] freq = new int[n + 1];

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            freq[factor]++;
            minPrice = Math.min(minPrice, price);
        }

        // Step 2: Count multiples for every factor
        int[] multiples = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                multiples[i] += freq[j];
            }
        }

        // Step 3: Store useful purchase options
        // Each option = {price, maximum free-gift copies}
        long[][] candidates = new long[n][2];

        int size = 0;

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            int gifts = multiples[factor] - 1;

            // Only useful if price < 2 * minimum price
            if (gifts > 0 && price < 2L * minPrice) {

                candidates[size][0] = price;
                candidates[size][1] = gifts;

                size++;
            }
        }

        // Step 4: Sort by price
        Arrays.sort(candidates, 0, size,
            (a, b) -> Long.compare(a[0], b[0]));

        // Step 5: Greedy selection
        long remaining = budget;
        long answer = 0;

        for (int i = 0; i < size; i++) {

            long price = candidates[i][0];
            long gifts = candidates[i][1];

            long take = Math.min(gifts, remaining / price);

            remaining -= take * price;

            // Each selected purchase gives:
            // 1 purchased item + 1 free item
            answer += take * 2;
        }

        // Spend remaining budget on cheapest items
        answer += remaining / minPrice;

        return (int) answer;
    }
}
