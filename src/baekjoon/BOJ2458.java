package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458 {
    static boolean [] visited;
    static boolean [][] adjMatrix;
    static int N;

    private static int dfs(int current) {
        visited[current] = true;
        int ret = 1;
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[current][i] && !visited[i]){
                ret += dfs(i);
            }
        }
        return ret;
    }

    private static int reverse_dfs(int current) {
        visited[current] = true;
        int ret = 1;
        for (int i = 1; i <= N; i++) {
            if (adjMatrix[i][current] && !visited[i]){
                ret += reverse_dfs(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        adjMatrix = new boolean[N + 1][N + 1];
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adjMatrix[s][e] = true;
        }
        int result;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            result = 0;
            visited = new boolean[N + 1];
            result += dfs(i);
            result += reverse_dfs(i);
            if (result-1 == N){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
