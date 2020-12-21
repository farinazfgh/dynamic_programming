public class KnapSack01BottomUp {
    static class Item {
        final int weight;
        final int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    /*

     */
    public int knapsack(Item[] items, int capacity) {
        int[][] cache = new int[items.length + 1][capacity + 1];
        // For each item and weight, compute the max value of the items up to that item that
        // doesn't go over capacity weight
        // i tells us which item to consider and capacity tells us the remaining weight
        //that we have available to us.
        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].weight > j) {
                    cache[i][j] = cache[i - 1][j];//take it from above row
                } else {
                    cache[i][j] = Math.max(
                            cache[i - 1][j],//We can get the value of not including the item by looking at the  solution for W = W and i = i - 1
                            cache[i - 1][j - items[i - 1].weight] + items[i - 1].value);
                    //We can get the value of including the item by looking at the max value we could get for W = W - item.weight.
                }
            }
        }
        return cache[items.length][capacity];
    }
}
