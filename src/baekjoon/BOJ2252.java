package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2252 {

    private static boolean [] visited;
    private static Node [] adjList;
    private static Stack<Integer> stack = new Stack<>();

    private static void dfs(int current) {
        visited[current] =  true;
        for (Node temp = adjList[current]; temp!=null; temp=temp.link){
            if (!visited[temp.vertex]){
                dfs(temp.vertex);
            }
        }
        stack.push(current);
    }

    static class Node {
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            this.vertex = vertex;
            this.link = link;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjList = new Node[N+1];
        visited = new boolean[N+1];
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
