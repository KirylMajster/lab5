package pl.knapsack;

public class Item {
    public int weight;
    public int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item [weight=" + weight + ", value=" + value + "]";
    }
}
