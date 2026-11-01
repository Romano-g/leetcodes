package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfWaysToAssignEdgeWeights {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[edges.length + 2];
        int maxDepth = 0;
        long result = 1;

        for (int i = 0; i <= edges.length + 1; i++) {
            graph.add(new ArrayList<>());
        }

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int node = current[0];
            int depth = current[1];

            if (depth > maxDepth) {
                maxDepth = depth;
            }

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, depth + 1});
                }
            }
        }

        for (int i = 0; i < maxDepth - 1; i++) {
            result = (result * 2) % MOD;
        }

        return (int) result;
    }
}

class TestNumberOfWaysToAssignEdgeWeights {
    static void main(String[] args) {
        NumberOfWaysToAssignEdgeWeights test = new NumberOfWaysToAssignEdgeWeights();

        int[][][] cases = {
                {{1,2}},
                {{1,2},{1,3},{3,4},{3,5}}
        };

        for (var c : cases) {
            var result = test.assignEdgeWeights(c);
            System.out.println(result);
        }
    }
}