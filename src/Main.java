import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String text = "bebebebabbabas";
        Map<Character, Integer> frequencies = Huffman.calculateFrequencies(text);
        Huffman.Node root = Huffman.buildHuffmanTree(frequencies);
        Map<Character, String> codes = Huffman.assignCodes(root);
        String encodedText = Huffman.encode(text, codes);
        String decodedText = Huffman.decode(root, encodedText);

        System.out.println("Original text: " + text);
        System.out.println("Encoded text: " + encodedText);
        System.out.println("Decoded text: " + decodedText);

//        BinSearchTree tree = new BinSearchTree();
//        tree.insert(33);
//        tree.insert(5);
//        tree.insert(4);
//        tree.insert(17);
//        tree.insert(35);
//        tree.insert(99);
//
//        System.out.println(tree.find(tree.root, 33));
//        System.out.println(tree.find(tree.root, 1));
//        tree.printTree(tree.root);
//        System.out.println();
//
//        tree.deleteRecursive(tree.root, 5);
//        tree.printTree(tree.root);
//        System.out.println();


//        Graph g = new Graph(4);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//
//        g.BFS(2);


        int INF = 99999999;
        int graph[][] = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        Floyd a = new Floyd();
        a.floyd(graph);
    }
}
