package lesson5;


import java.util.Arrays;

public class Knapsack {
    private KnapsackItem[] items;
    private final int DEFAULT_CAPACITY = 10;
    private float maxWeight;
    private int item;


    public Knapsack() {
        items = new KnapsackItem[DEFAULT_CAPACITY];
    }

    public void add(String name, float weight, float cost){

        //recapacity
        if (item == items.length){
            KnapsackItem[] temp = Arrays.copyOf(items, items.length * 2);
            items = temp;
        }

        items[item] = new KnapsackItem(name, weight, cost);
        item++;

    }

    public void calcAndPrint(float maxWeight){
        this.maxWeight = maxWeight;
        ResultPath resultPath = checkItem(new ResultPath(), 0);
        ResultPath cumulative = new ResultPath();
        for (int i = 0; i < item; i++) {
            if ((resultPath.path & (1 << i)) > 0){
                cumulative.addItemPath(i);
                System.out.printf("[V]%s %s\n", items[i].toString(), cumulative.toString());
            } else {
                cumulative.noItemPath(i);
                System.out.printf("[ ]%s %s\n", items[i].toString(), cumulative.toString());
            }

        }
    }





    /**
     * Рекурсивная проверка, брать с собой элемент, или не брать
     * возвращает ценность рюкзака
     */
    private ResultPath checkItem(ResultPath currentValue, int itemIndex){

        ResultPath val = new ResultPath(currentValue);

        if (itemIndex < item) {

            //Первый рекурентный случай - не добавляем предмет в рюкзак и запускаем цепочку дальше
            ResultPath noItemValue = checkItem(val.noItemPath(itemIndex + 1), itemIndex + 1);

            //Второй базовый случай - предмет не влезает в рюкзак
            if (val.weight + items[itemIndex].weight > maxWeight) return max(val, noItemValue);

            //Второй рекурентный случай - добавляем текущий предмет в рюкзак и запускаем цепочку дальше
            ResultPath itemValue = checkItem(val.addItemPath(itemIndex), itemIndex + 1);

            //Возвращаем максимальную стоимость из выбранных вариантов
            return max(noItemValue, itemValue);
        }

        return val;

    }

    private class KnapsackItem {

        private String name;
        private float weight;
        private float cost;
        private float value;

        public KnapsackItem(String name, float weight, float cost) {
            this.name = name;
            this.weight = weight;
            this.cost = cost;
            this.value = cost / weight;
        }

        public float getValue(){
            return value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Наименование='").append(name).append('\'');
            sb.append(", вес=").append(weight);
            sb.append(", стоимость=").append(cost);
            sb.append(", ценность=").append(value).append("руб/кг");
            return sb.toString();
        }
    }

    private class ResultPath{
        long path;
        float value;
        float weight;
        float cost;
        private int index;

        public ResultPath(){};

        public ResultPath(ResultPath val){
            this.path = val.path;
            this.value = val.value;
            this.weight = val.weight;
            this.cost = val.cost;
            this.index = val.index;
        }

        public ResultPath addItemPath(int index){
            this.value += items[index].value;
            this.weight += items[index].weight;
            this.cost += items[index].cost;
            path = path | (1 << index);
            //System.out.println(path);
            this.index = index;
            return this;
        }


        public ResultPath noItemPath(int index) {
            this.index = index;
            //path = ~((~path) | 1 << index);
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Параметры отбора{");
            sb.append("бинарный путь=").append(Long.toBinaryString(path));
            sb.append(", итоговая цена=").append(value);
            sb.append(", итоговый вес=").append(weight);
            sb.append(", итоговая ценность=").append(cost);
            sb.append(", номер=").append(index);
            sb.append('}');
            return sb.toString();
        }
    }

    private ResultPath max(ResultPath a, ResultPath b){
        return a.value > b.value ? a : b;
    }
}


