public class HashTableKv {
    private String[] table;
    private int capacity;

    public HashTableKv(int capacity) {
        this.capacity = capacity;
        this.table = new String[capacity];
    }

    public void insert(String key, String value) {
        int hash = Math.abs(key.hashCode()) % capacity;
        int index = hash;
        int i = 1;

        while (table[index] != null) {
            index = (hash + i * i) % capacity;
            i++;
        }

        table[index] = value;
    }

    public String get(String key) {
        int hash = Math.abs(key.hashCode()) % capacity;
        int index = hash;


        if (table[index] != null) {
            return table[index];
        }
        return null;
    }


}