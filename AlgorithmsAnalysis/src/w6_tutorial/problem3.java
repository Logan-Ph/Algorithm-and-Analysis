package w6_tutorial;

public class problem3 {
    Item[] items;
    boolean[] bestSubset;
    int maxValue;
    int capacity;

    public problem3(Item[] items, int capacity){
        this.items = items;
        this.capacity = capacity;
    }

    public void start(){
        subset(new boolean[items.length], 0);
    }

    public void subset(boolean[] selected, int index){
        if (index == selected.length){
            process(selected);
            return;
        }

        selected[index] = true;
        subset(selected, index+1);

        selected[index] = false;
        subset(selected, index+1);
    }

    public void process(boolean[] selected){
        int weight = 0, value = 0;

        for (int i = 0 ; i < selected.length; i++){
            if (selected[i]){
                weight += items[i].weight;
                value += items[i].value;

                if (weight > capacity){
                    return;
                }
            }
        }

        if (value > maxValue){
            maxValue = value;
            bestSubset = selected.clone();
        }
    }

    public void displaySubset(){
        StringBuilder st = new StringBuilder();
        int totalWeight = 0;
        for (int i =0; i < bestSubset.length; i++){
            if (bestSubset[i]){
                totalWeight += items[i].weight;
                st.append(String.format(" item(weight: %d, value: %d)", items[i].weight, items[i].value));
            }
        }
        st.append(String.format(" with total weight %d and total value %d", totalWeight, maxValue));
        System.out.println(st);
    }

    public static void main(String[] args) {
        Item[] items = new Item[] {
            new Item(7, 42),
            new Item(3, 12),
            new Item(4, 40),
            new Item(5, 25)
          };
        problem3 knapsack = new problem3(items, 7);
        knapsack.start();
        knapsack.displaySubset();
    }
}

class Item {
    int weight;
    int value;

    public Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }
}