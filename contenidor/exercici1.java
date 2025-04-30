package contenidor;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Sequence implements Iterable<Integer> {
    private int[] data = {1, 5, 6, 7, -1, 2};

    @Override
    public Iterator<Integer> iterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < data.length;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[index++];
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (Integer i : sequence) {
            System.out.println(i);
        }
    }
}
