package ca.bcit.comp2522.labs.lab06;

import java.util.ArrayList;
import java.util.Objects;

public class OrderedPair<K, V> {
    private K first;
    private V second;

    public OrderedPair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static<K, V> boolean same(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.equals(p2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedPair<?, ?> that = (OrderedPair<?, ?>) o;
        return Objects.equals(first, that.first) &&
                Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static void main(String[] args) {
        OrderedPair<String, String> stringOrderedPair = new OrderedPair<>("J", "Kwok");
        OrderedPair<Integer, ArrayList<Integer>> integerArrayListOrderedPair = new OrderedPair<>(2, new ArrayList<Integer>(3));
        OrderedPair<Box<Double>, Box<Double>> boxBoxOrderedPair = new OrderedPair<>(new Box<Double>(1.0), new Box<Double>(2.0));

        OrderedPair<Integer, Integer> pair1 = new OrderedPair<>(2, 3);
        OrderedPair<Integer, Integer> pair2 = new OrderedPair<>(2, 3);
        OrderedPair<Integer, Integer> pair3 = new OrderedPair<>(3, 3);

        System.out.println(same(pair1, pair2));
        System.out.println(same(pair1, pair3));
    }
}

class Box<T> {
    private T type;

    public Box(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}