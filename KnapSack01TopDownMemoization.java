import java.util.HashMap;
import java.util.Map;

public class KnapSack01TopDownMemoization {
    public static int knapsack(Item[] items, int capacity) {
        // Map: i -> W -> value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return knapsack(items, capacity, 0, cache);
    }

    private static int knapsack(Item[] items, int capacity, int index, Map<Integer, Map<Integer, Integer>> cache) {
        if (index == items.length) return 0;
        if (!cache.containsKey(index)) cache.put(index, new HashMap<>());
        Integer value = cache.get(index).get(capacity);
        if (value != null) return value;
        int profit;
        if (items[index].weight > capacity) {
            profit = knapsack(items, capacity, index + 1, cache);//skip dont include item
        } else {
            profit = Math.max(
                    knapsack(items, capacity - items[index].weight, index + 1, cache) + items[index].profit,//we include items[item] item consider its value
                    knapsack(items, capacity, index + 1, cache));
        }
        cache.get(index).put(capacity, profit);
        return profit;
    }

    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(2, 6);
        items[1] = new Item(2, 10);
        items[2] = new Item(3, 12);
        int maxWeight = 5;
        System.out.println(knapsack(items, maxWeight));


    }

    static class Item {
        final int weight;
        final int profit;

        public Item(int weight, int profit) {
            this.weight = weight;
            this.profit = profit;
        }
    }
}
