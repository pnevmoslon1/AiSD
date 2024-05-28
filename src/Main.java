
public class Main {
    public static void main(String[] args) {
//        BinSearchTree tree = new BinSearchTree();
//        tree.insert(33);
//        tree.insert(5);
//        tree.insert(4);
//        tree.insert(17);
//        tree.insert(35);
//        tree.insert(99);
////        System.out.println(tree.find(33));
////        System.out.println(tree.find(1));
//        tree.printTree(tree.root);
//        System.out.println();
//        tree.delete(5);
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


        int INF = 999999999;
        int graph[][] = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        FloydWarshall a = new FloydWarshall();
        a.floydWarshall(graph);
    }

}
