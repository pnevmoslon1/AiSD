public class QueueOnArray {
    public int size;
    public int[] arr;
    public int numElems;
    public int first;
    public int last;

    public void Queue(int size) {
        this.size = size;
        arr = new int[size];
        numElems = 0;
        first = 0;
        last = -1;
    }

    public void add(int n) {
        if (last + 1 > size) {
            last = -1;
        }
        last++;
        arr[last] = n;
    }

    public int remove() {
        int temp = arr[first];
        if (first == size) {
            first = 0;
        }
        numElems--;
        first++;
        return temp;
    }

    public int getFirst() {
        return arr[first];
    }

    public int getLast() {
        return arr[last];
    }

    public boolean isFull() {
        return numElems == size - 1;
    }

    public boolean isEmpty() {
        return numElems == 0;
    }

    public int getSize() {
        return numElems;
    }

}
