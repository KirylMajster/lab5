package pl.knapsack;

public class Main {
    public static void main(String[] args) {
        Problem problem = new Problem(5, 123, 1, 10);
        System.out.println(problem);

        int capacity = 25;
        Result result = problem.solve(capacity);
        System.out.println(result);
    }
}
