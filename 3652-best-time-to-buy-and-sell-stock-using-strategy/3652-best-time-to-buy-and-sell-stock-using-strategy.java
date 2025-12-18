class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // Step 1: base profit
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        int half = k / 2;
        long origProfit = 0, sellPart = 0;

        // initialize first window
        for (int j = 0; j < k; j++) {
            origProfit += (long) strategy[j] * prices[j];
            if (j >= half) {
                sellPart += prices[j];
            }
        }

        // allow "no modification" by starting at 0
        long bestDelta = 0;  

        // include first window delta
        bestDelta = Math.max(bestDelta, sellPart - origProfit);

        // slide window
        for (int i = 1; i + k <= n; i++) {
            // outgoing element
            origProfit -= (long) strategy[i - 1] * prices[i - 1];
            sellPart -= prices[i - 1 + half];

            // incoming element
            int newIdx = i + k - 1;
            origProfit += (long) strategy[newIdx] * prices[newIdx];
            sellPart += prices[newIdx];

            bestDelta = Math.max(bestDelta, sellPart - origProfit);
        }

        return base + bestDelta;
    }
}
