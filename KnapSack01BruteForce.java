public class KnapSack01BruteForce {
    static class Item {
        final int weight;
        final int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // Naive brute force solution. Recursively
    // include or exclude each item to try every
    // possible combination
    static int knapsack(Item[] items, int maxWeight) {
        return knapsack(items, maxWeight, 0);
    }

    // Overloaded recursive function
    static int knapsack(Item[] items, int maxWeight, int index) {
        if (index == items.length) return 0;
        System.out.println("maxWeight: " + maxWeight + ", index: " + index);
        if (items[index].weight > maxWeight)
            return knapsack(items, maxWeight, index + 1); // If the item is too big to fill the remaining space, skip it

        return Math.max(
                knapsack(items, maxWeight - items[index].weight, index + 1) + items[index].value,
                knapsack(items, maxWeight, index + 1)
        );
        // Find the maximum of including and not including the current item
    }

    public static void main(String[] args) {
        Item[] items = new Item[3];
        items[0] = new Item(2, 6);
        items[1] = new Item(2, 10);
        items[2] = new Item(3, 12);
        int maxWeight = 5;
        System.out.println(knapsack(items, maxWeight));


    }
}
