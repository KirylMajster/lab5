package pl.knapsack;

import java.util.HashMap;
import java.util.Map;

public class Result {
    public Map<Integer, Integer> itemCounts = new HashMap<>();
    public int totalWeight = 0;
    public int totalValue = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Solution:\n");
        for (Map.Entry<Integer, Integer> entry : itemCounts.entrySet()) {
            sb.append("Item ").append(entry.getKey())
                    .append(" x").append(entry.getValue()).append("\n");
        }
        sb.append("Total weight: ").append(totalWeight).append("\n");
        sb.append("Total value: ").append(totalValue).append("\n");
        return sb.toString();
    }
}
