package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {

    static boolean [] visited;
    static int N, M, V;
    static boolean [][]adjMatrix;
    static StringBuilder sb = new StringBuilder();
    static void bfs(int start) {
        visited = new boolean[N];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int current = 0;
        while(!queue.isEmpty()){
            current = queue.poll();
            sb.append(current+1).append(" ");
            for (int i = 0; i < N; i++) {
                if (adjMatrix[current][i] && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void dfs(int idx){
        if (!visited[idx]){
            visited[idx] = true;
            sb.append(idx+1).append(" ");
            for (int i = 0; i < N; i++) {
                if (adjMatrix[idx][i])
                    dfs(i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호
        visited = new boolean[N];
        adjMatrix = new boolean[N][N];
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from= Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            adjMatrix[from-1][to-1] = true;
            adjMatrix[to-1][from-1] = true;
        }
        dfs(V-1);
        sb.append("\n");
        bfs(V-1);
        System.out.println(sb);
    }
}
