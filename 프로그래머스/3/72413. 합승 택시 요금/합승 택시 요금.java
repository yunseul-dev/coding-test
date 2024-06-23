import java.util.*;

public class Solution {
    public class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public class Dijkstra {
        ArrayList<ArrayList<Node>> graph;
        int[] dist;

        public Dijkstra(int n, int[][] list) {
            graph = new ArrayList<>();
            dist = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] ints : list) {
                graph.get(ints[0]).add(new Node(ints[1], ints[2]));
                graph.get(ints[1]).add(new Node(ints[0], ints[2]));
            }
        }

        public int[] findPath(int start) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node curNode = pq.poll();

                if (dist[curNode.to] < curNode.weight) {
                    continue;
                }

                for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                    Node adjNode = graph.get(curNode.to).get(i);
                    if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                        dist[adjNode.to] = curNode.weight + adjNode.weight;
                        pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                    }
                }
            }

            return dist.clone();
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        Dijkstra dijkstra = new Dijkstra(n, fares);

        int[] distFromS = dijkstra.findPath(s);
        int[] distFromA = dijkstra.findPath(a);
        int[] distFromB = dijkstra.findPath(b);

        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
                minCost = Math.min(minCost, distFromS[i] + distFromA[i] + distFromB[i]);
        }

        return minCost;
    }
}
