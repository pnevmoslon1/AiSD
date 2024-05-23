public class BloomFilter {
    private byte[] table;

    public BloomFilter(int len) {
        table = new byte[len];
    }

    private int firstHash(String word) {
        int sum = 0;
        for (char c : word.toCharArray()) {
            sum += (int) c;
        }
        return sum % table.length;
    }

    private int secondHash(String word) {
        long sum = 0;
        char[] temp = word.toCharArray();
        for (int i = temp.length - 1; i >= 0; i--) {
            sum += ((long) ((int) temp[i] * Math.pow(15, i))) % table.length;
        }
        return (int) sum % table.length;
    }

    public void add(String word) {
        table[firstHash(word)] = 1;
        table[secondHash(word)] = 1;
    }

    public boolean contains(String word) {
        if (table[firstHash(word)] == 1 && table[secondHash(word)] == 1) {
            return true;
        }
        return false;
    }
}