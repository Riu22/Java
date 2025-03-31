package contenidor;

import java.util.*;

class IntList extends AbstractList<Integer> {
    private Integer[] data;

    IntList(int[] data) {
        this.data = Arrays.stream(data).boxed().toArray(Integer[]::new);
    }

    @Override
    public Integer get(int index) {
        return data[index];
    }

    @Override
    public int size() {
        return data.length;
    }
}

public class exercici6 {
    public static void main(String[] args) {
        List<Integer> il = new IntList(new int[]{1, 2, 3});

        System.out.println("Size: " + il.size());

        System.out.println("Element at index 1: " + il.get(1));

        try {
            il.add(10);
        } catch (UnsupportedOperationException e) {
            System.out.println("Add operation not supported!");
        }

        Iterator<Integer> iterator = il.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("Contains 2? " + il.contains(2));

        System.out.println("Sublist (1,3): " + il.subList(1, 3));

        try {
            il.remove(1);
        } catch (UnsupportedOperationException e) {
            System.out.println("Remove operation not supported!");
        }

        Object[] array = il.toArray();
        System.out.println("Array: " + Arrays.toString(array));
    }
}

