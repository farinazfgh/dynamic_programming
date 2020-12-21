import java.util.HashMap;
import java.util.Map;

public class KnapSack01TopDownMemoization {
    public static int knapsack(Item[] items, int capacity) {
        // Map: i -> W -> value
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return knapsack(items, capacity, 0, cache);
    }

    private static int knapsack(Item[] items, int capacity, int item, Map<Integer, Map<Integer, Integer>> cache) {
        if (item == items.length) return 0;
        if (!cache.containsKey(item)) cache.put(item, new HashMap<>());
        Integer value = cache.get(item).get(capacity);
        if (value != null) return value;
        int toReturn;
        if (items[item].weight > capacity) {
            toReturn = knapsack(items, capacity, item + 1, cache);//skip dont include item
        } else {
            toReturn = Math.max(
                    knapsack(items, capacity - items[item].weight, item + 1, cache) + items[item].value,//we include items[item] item consider its value
                    knapsack(items, capacity, item + 1, cache));
        }
        cache.get(item).put(capacity, toReturn);
        return toReturn;
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
        final int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
