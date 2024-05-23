import java.util.Arrays;
import java.util.LinkedList;

public class HashTable {
    private static final int SIZE = 10;
    private LinkedList<int[]>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }


    public void put(int[] key, int value) {
        int hash = Math.abs(Arrays.hashCode(key)) % SIZE;;
        int[] pair = {key[0], value};
        table[hash].add(pair);
    }


    public Integer get(int[] key) {
        int hash = Math.abs(Arrays.hashCode(key)) % SIZE;;
        for (int[] pair : table[hash]) {
            if (pair[0] == key[0]) {
                return pair[1];
            }
        }
        return null;
    }


    public boolean remove(int[] key) {
        int hash = Math.abs(Arrays.hashCode(key)) % SIZE;;
        for (int[] pair : table[hash]) {
            if (pair[0] == key[0]) {
                table[hash].remove(pair);
                return true;
            }
        }
        return false;
    }

}