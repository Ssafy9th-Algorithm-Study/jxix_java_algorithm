package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2623 {
    static int N;
    static boolean [][] adjMatrix;
    static boolean [] visited;
    static List<Integer> order = new ArrayList<>();

    private static void dfs(int current){
        visited[current] = true;
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[current][i] && !visited[i]){
                dfs(i);
            }
        }
        order.add(current);
    }

    private static boolean isPossilbe(){
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N ; j++) {
                if (adjMatrix[order.get(j)][order.get(i)])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adjMatrix = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 1; j < cnt; j++) {
                int to = Integer.parseInt(st.nextToken());
                adjMatrix[from][to]=true;
                from = to;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i])
                dfs(i);
        }
        Collections.reverse(order);
        if (isPossilbe()){
            for (int i = 0; i < N; i++) {
                sb.append(order.get(i)).append("\n");
            }
        } else {
            sb.append(0);
        }
        System.out.println(sb);
    }
}
