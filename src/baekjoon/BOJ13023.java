package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13023 {

    static int answer = 0;
    static int N, M;
    static boolean [] visited;
    static Node[] adjList;
    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    static void dfs(int idx, int cnt) {
        visited[idx] = true;
        if (cnt == 4){
            answer = 1;
            return;
        }
        for (Node temp = adjList[idx]; temp!= null;temp = temp.link){
            if (!visited[temp.vertex])
                dfs(temp.vertex, cnt+1);
        }
        visited[idx]=false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        adjList = new Node[N];
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }
        System.out.println(answer);
    }
}
