package contenidor;

import java.util.PriorityQueue;

class Car implements Comparable<Car> {
    private String brand;
    private int value;

    public Car(String brand, int value) {
        this.brand = brand;
        this.value = value;
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return brand;
    }

    public static void main(String[] args) {
        PriorityQueue<Car> pq = new PriorityQueue<>();
        pq.offer(new Car("Renault", 15));
        pq.offer(new Car("Fiat", 5));
        pq.offer(new Car("Mercedes", 25));
        pq.offer(new Car("Volkswagen", 20));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
