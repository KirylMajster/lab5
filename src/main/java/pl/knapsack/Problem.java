package pl.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;
    private List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();

        Random random = new Random(seed);
        for (int i = 0; i < n; i++) {
            int weight = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            int value = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            items.add(new Item(weight, value));
        }
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Generated Items:\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append("[").append(i).append("] ").append(items.get(i)).append("\n");
        }
        return sb.toString();
    }

    public Result solve(int capacity) {
        // Utwórz listę indeksów przedmiotów
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            indices.add(i);
        }

        // Posortuj po stosunku value/weight (malejąco)
        indices.sort((i1, i2) -> {
            double ratio1 = (double) items.get(i1).value / items.get(i1).weight;
            double ratio2 = (double) items.get(i2).value / items.get(i2).weight;
            return Double.compare(ratio2, ratio1);
        });

        Result result = new Result();
        int remaining = capacity;

        for (int i : indices) {
            Item item = items.get(i);
            int maxCount = remaining / item.weight;

            if (maxCount > 0) {
                result.itemCounts.put(i, maxCount);
                result.totalWeight += item.weight * maxCount;
                result.totalValue += item.value * maxCount;
                remaining -= item.weight * maxCount;
            }
        }

        return result;
    }
}


