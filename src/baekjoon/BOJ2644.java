package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2644 {

    static boolean[][] map;
    static boolean[] visited;
    static int answer = -1;

    static void dfs(int idx, int end, int N, int cnt) {
        visited[idx] = true;
        if (idx == end) {
            answer = cnt;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (map[idx][i] && !visited[i])
                dfs(i, end, N, cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            map[u - 1][v - 1] = true;
            map[v - 1][u - 1] = true;
        }
        dfs(start - 1, end - 1, N, 0);
        System.out.println(answer);
    }
}
