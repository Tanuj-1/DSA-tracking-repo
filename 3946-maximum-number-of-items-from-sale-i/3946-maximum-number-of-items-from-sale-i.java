class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] dp = new int[budget + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            minPrice = Math.min(minPrice, price);

            // copies gained by buying the first copy of this type
            int value = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) value++;
            }

            // 0/1 knapsack, iterate budget in reverse
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + value);
            }
        }

        int ans = 0;
        for (int c = 0; c <= budget; c++) {
            ans = Math.max(ans, dp[c] + (budget - c) / minPrice);
        }
        return ans;
    }
}