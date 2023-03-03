package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static Queue<int[]> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = -1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1 && !visited[r][c]) {
                    queue.offer(new int[]{r, c, 0});
                }
            }
        }
        ans = bfs();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
               if (map[r][c] == 0){
                   ans = -1;
                   break;
               }
            }
        }
        System.out.println(ans);
    }

    private static int bfs() {
        int[] current = new int[3];
        while (!queue.isEmpty()) {
            current = queue.poll();
            int nr, nc;
            for (int d = 0; d < 4; d++) {
                nr = current[0] + dr[d];
                nc = current[1] + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0){
                    map[nr][nc] = 1;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc, current[2] + 1});
                }
            }
        }
        return current[2];
    }
}
