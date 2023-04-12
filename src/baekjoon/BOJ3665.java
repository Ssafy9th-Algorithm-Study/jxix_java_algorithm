package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ3665 {

    static boolean [][] adjMatrix;
    static boolean [] visited;
    static int N;
    static List<Integer> order;

    static void dfs(int current){
        visited[current] = true;
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[current][i] && !visited[i]){
                dfs(i);
            }
        }
        order.add(current);
    }

    static boolean isPossible() {
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (adjMatrix[order.get(j)][order.get(i)])
                    return false;
            }
        }
        return true;
    }

    static void topologicalSort() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                dfs(i);
        }
        Collections.reverse(order);
        if (isPossible()){
            for (int i = 0; i < N; i++) {
                sb.append(order.get(i)).append(" ");
            }
        } else {
            sb.append("IMPOSSIBLE");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            adjMatrix = new boolean[N+1][N+1];
            visited = new boolean[N+1];
            order = new ArrayList<>();
            int[] origin_ranking = new int[N+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                origin_ranking[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                for (int j = i+1; j <= N; j++) {
                    adjMatrix[origin_ranking[i]][origin_ranking[j]]=true;
                }
            }
            int M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (adjMatrix[a][b]){
                    adjMatrix[a][b]=false;
                    adjMatrix[b][a]=true;
                } else {
                    adjMatrix[a][b]=true;
                    adjMatrix[b][a]=false;
                }
            }
            topologicalSort();
        }
    }
}
