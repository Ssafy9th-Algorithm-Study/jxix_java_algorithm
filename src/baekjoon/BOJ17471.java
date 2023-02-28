package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17471 {

    static Node[] adjList;
    static boolean[] visited;
    static boolean[] selected;
    static int[] populations;

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }


    static int bfs(int start, boolean flag) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int sum = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sum += populations[current];
            for (Node temp = adjList[current]; temp != null; temp = temp.link) {
                if (!visited[temp.vertex] && (selected[temp.vertex] == flag)) {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        populations = new int[N];
        adjList = new Node[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            populations[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int to = Integer.parseInt(st.nextToken());
                adjList[i] = new Node(to - 1, adjList[i]);
                adjList[to - 1] = new Node(i, adjList[to - 1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << N); i++) {
            int sum1 = 0;
            int sum2 = 0;
            int start1 = 0;
            int start2 = 0;
            selected = new boolean[N];
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    selected[j] = true;
                    sum1 += populations[j];
                    start1 = j;
                } else {
                    selected[j] = false;
                    sum2 += populations[j];
                    start2 = j;
                }
            }
            visited = new boolean[N];
            if (sum1 == 0 || sum2 == 0)
                continue;
            if (sum1 == bfs(start1, true) && sum2 == bfs(start2, false)) {
                min = Math.min(min, Math.abs(sum1 - sum2));
            }
        }
        if (min == Integer.MAX_VALUE)
            min = -1;
        System.out.println(min);
    }
}
