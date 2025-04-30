package contenidor;
import java.util.*;

public class exercici8_9 {
    static final int ELEMENTS = 5_000_000;
    static final int TESTS = 1_000;

    public static void fill(List<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(rand.nextInt());
        }
    }

    public static void test(List<Integer> list) {
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TESTS; i++) {
            int index = rand.nextInt(ELEMENTS);
            list.get(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass().getSimpleName() + " random access time: " + (endTime - startTime) + " ms");
    }

    public static void testInsertDelete(List<Integer> list) {
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < TESTS; i++) {
            int index = list.size() / 2;
            list.add(index, rand.nextInt());
            list.remove(index);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(list.getClass().getSimpleName() + " insert/delete middle time: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        fill(arrayList);
        List<Integer> linkedList = new LinkedList<>();
        fill(linkedList);

        test(arrayList);
        test(linkedList);

        testInsertDelete(arrayList);
        testInsertDelete(linkedList);
    }
}