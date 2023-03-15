package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1753 {

    static class Node {
        int vertex;
        int weight;
        Node link;

        public Node(int vertex, int weight, Node link) {
            this.vertex = vertex;
            this.weight = weight;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = Integer.MAX_VALUE;

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        Node[] adjList = new Node[V + 1];

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjList[u] = new Node(v, w, adjList[u]);
        }

        int[] distance = new int[V + 1];
        boolean[] visited = new boolean[V + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        int min, current;
        for (int c = 1; c <= V; c++) {
            current = -1;
            min = INF;

            for (int i = 1; i <= V; i++) {
                if (!visited[i] && min > distance[i]) {
                    min = distance[i];
                    current = i;
                }
            }
            if (current == -1) {
                break;
            }
            visited[current] = true;

            for (Node temp = adjList[current]; temp != null; temp = temp.link) {
                if (distance[temp.vertex] > min + temp.weight) {
                    distance[temp.vertex] = min + temp.weight;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] < INF ? distance[i] : "INF").append("\n");
        }
        System.out.print(sb);
    }
}
