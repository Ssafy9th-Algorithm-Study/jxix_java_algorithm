package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {

    static Node [] adjList;
    static boolean[] visited;
    static int [] depth;
    static StringBuilder sb = new StringBuilder();
    static class Node {
        int vertex;
        Node next;

        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }

    private static void init(){
        adjList = new Node[101];
        visited = new boolean[101];
        depth = new int[101];
    }

    private static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int ans = 0;
        int maxDepth = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (Node temp = adjList[current]; temp != null; temp = temp.next){
                if (!visited[temp.vertex]) {
                    queue.offer(temp.vertex);
                    visited[temp.vertex] = true;
                    depth[temp.vertex] = depth[current] + 1;
                    if (maxDepth < depth[temp.vertex])
                        maxDepth = depth[temp.vertex];
                }
            }
        }
        for (int i = 1; i < 101; i++) {
            if (depth[i] == maxDepth){
                if (ans < i)
                    ans = i;
            }
        }
        sb.append(ans).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            init();
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int from, to;
            for (int i = 0; i < N/2; i++) {
                from = Integer.parseInt(st.nextToken());
                to = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, adjList[from]);
            }
            bfs(S);
        }
        System.out.print(sb);
    }
}
