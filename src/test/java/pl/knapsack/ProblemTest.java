package pl.knapsack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    @Test
    public void testGeneratedItemCount() {
        Problem problem = new Problem(10, 42, 1, 10);
        assertEquals(10, problem.getItems().size());
    }

    @Test
    public void testAllWeightsAndValuesInRange() {
        Problem problem = new Problem(100, 123, 1, 10);
        for (Item item : problem.getItems()) {
            assertTrue(item.weight >= 1 && item.weight <= 10);
            assertTrue(item.value >= 1 && item.value <= 10);
        }
    }

    @Test
    public void testNoItemsFit() {
        Problem problem = new Problem(5, 1, 10, 10); // Wszystkie mają wagę 10
        Result result = problem.solve(5); // Pojemność < 10
        assertEquals(0, result.totalWeight);
        assertEquals(0, result.totalValue);
        assertTrue(result.itemCounts.isEmpty());
    }

    @Test
    public void testCorrectSolutionForKnownInput() {
        Problem problem = new Problem(3, 0, 1, 1); // Wszystkie przedmioty mają wagę i wartość = 1
        Result result = problem.solve(5);
        assertEquals(5, result.totalWeight);
        assertEquals(5, result.totalValue);
        int totalItems = result.itemCounts.values().stream().mapToInt(i -> i).sum();
        assertEquals(5, totalItems);
    }
}
