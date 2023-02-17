package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {

    static boolean[][] computers;
    static boolean[] visited;
    static int count = 0;
    static void dfs(int idx, int N, int cnt){
        visited[idx] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && computers[idx][i]){
                dfs(i, N,cnt+1);
                count++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        computers = new boolean[N][N];
        visited = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            computers[c1 - 1][c2 - 1] = true;
            computers[c2 - 1][c1 - 1] = true;
        }
        dfs(0, N, 0);
        System.out.println(count);
    }
}
