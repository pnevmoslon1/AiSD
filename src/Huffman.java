import java.util.*;

public class Huffman {

    public static Map<Character, Integer> calculateFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        return frequencies;
    }

    public static Node buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            queue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0', left.frequency + right.frequency, left, right);
            queue.add(parent);
        }

        return queue.poll();
    }

    public static Map<Character, String> assignCodes(Node root) {
        Map<Character, String> codes = new HashMap<>();
        assignCodesHelper(root, "", codes);
        return codes;
    }

    public static void assignCodesHelper(Node node, String code, Map<Character, String> codes) {
        if (node != null) {
            if (node.character != '\0') {
                codes.put(node.character, code);
            }
            assignCodesHelper(node.left, code + "0", codes);
            assignCodesHelper(node.right, code + "1", codes);
        }
    }

    public static String encode(String text, Map<Character, String> codes) {
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            encoded.append(codes.get(c));
        }
        return encoded.toString();
    }

    public static String decode(Node root, String encoded) {
        StringBuilder decoded = new StringBuilder();
        Node current = root;
        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.character != '\0') {
                decoded.append(current.character);
                current = root;
            }
        }
        return decoded.toString();
    }

    static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left, right;

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        Node(char character, int frequency, Node left, Node right) {
            this.character = character;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }
}