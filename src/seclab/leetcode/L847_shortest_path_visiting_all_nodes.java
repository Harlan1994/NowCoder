package seclab.leetcode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/9/7
 * Time: 10:38
 * Description:
 * <p>
 * An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.
 * graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.
 * Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.
 * <p>
 * Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
 * Output: 4
 * Explanation: One possible path is [0,1,4,2,3]
 * <p>
 * Input: [[1,2,3],[0],[0],[0]]
 * Output: 4
 * Explanation: One possible path is [1,0,2,0,3]
 * <p>
 * Solution:
 * 要点：无向连通图，遍历所有的节点、可重复走边，起始点和终点随意
 * 因为是无向图，起始点和终点其实无所谓，因为只要找到最短路径
 */
public class L847_shortest_path_visiting_all_nodes {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfNodes = Integer.parseInt(scanner.nextLine());
        int[][] graph = new int[numberOfNodes][numberOfNodes];
        for (int i = 0; i < numberOfNodes - 1; i++) {
            String[] splits = scanner.nextLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);
            graph[x - 1][y - 1] = 1;
        }
        System.out.println(new L847_shortest_path_visiting_all_nodes().shortestPathLength(graph));
    }


    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        Queue<Tuple> queue = new LinkedList<>();
        // Used to avoid visiting duplicate path
        Set<Tuple> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int mask = (1 << i);
            // We don't care about length of path when checking duplicate path
            set.add(new Tuple(mask, i, 0));
            queue.offer(new Tuple(mask, i, 0));
        }

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            if (tuple.mask == (1 << N) - 1) {
                // This path has visited all nodes, and it's guaranteed this is the shortest one by
                // BFS so return it
                return tuple.len;
            } else {
                for (int v : graph[tuple.head]) {
                    int mask = tuple.mask | (1 << v);
                    Tuple t = new Tuple(mask, v, 0);
                    if (!set.contains(t)) {
                        queue.offer(new Tuple(mask, v, tuple.len + 1));
                        set.add(t);
                    }
                }
            }
        }
        // Should not reach here
        return -1;
    }

    class Tuple {
        int mask; // Stores the visited nodes in this path
        int head; // Head of current path
        int len; // Length of the path

        public Tuple(int mask, int head, int len) {
            this.mask = mask;
            this.head = head;
            this.len = len;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Tuple) {
                Tuple t = (Tuple)o;
                return this.mask == t.mask &&
                        this.head == t.head &&
                        this.len == t.len;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mask, head, len);
        }
    }
}
