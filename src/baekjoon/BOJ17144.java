package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17144 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;
    static int R, C;
    static int[][] map;
    static int[][] copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        queue = new ArrayDeque<>();
        int airCleaner = -1;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                airCleaner = i;
                break;
            }
        }

        for (int t = 0; t < T; t++) {
            //미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] > 0) {
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            bfs();
            //공기청정기가 작동한다
            airCleaner1(airCleaner);
            airCleaner2(airCleaner + 1);
        }
        int ans = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0) {
                    ans += map[r][c];
                }
            }
        }
        System.out.println(ans);
    }

    private static void bfs() {
        copyMap = new int[R][C];
        int[] current;
        int r, c, nr, nc, count;
        while (!queue.isEmpty()) {
            current = queue.poll();
            count = 0;
            r = current[0];
            c = current[1];
            for (int d = 0; d < 4; d++) {
                nr = r + dx[d];
                nc = c + dy[d];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != -1) {
                    count++;
                    copyMap[nr][nc] += (map[r][c] / 5);
                }
            }
            map[r][c] -= ((map[r][c] / 5) * count);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    map[i][j] += copyMap[i][j];
                }
            }
        }
    }

    private static void airCleaner1(int r) {
        // 공기 청정기가 0,0에 있을 때
        int nr, nc;
        if (r == 0) {
            nr = r;
            nc = C - 1;
            while (nc > 0) {
                map[nr][nc] = map[nr][nc - 1];
                nc--;
            }
            map[r][1] = 0;
        } else {
            // 아닐 때
            nr = r - 1;
            nc = 0;
            // 위에서 아래로..
            while (nr > 0) {
                map[nr][nc] = map[nr - 1][nc];
                nr--;
            }
            // <- 방향
            while (nc < C - 1) {
                map[nr][nc] = map[nr][nc + 1];
                nc++;
            }
            //아래에서 위로 올라오는 방향
            while (nr < r) {
                map[nr][nc] = map[nr + 1][nc];
                nr++;
            }
            // -> 방향
            while (nc > 0) {
                map[nr][nc] = map[nr][nc - 1];
                nc--;
            }
            map[r][1] = 0;
        }
    }

    private static void airCleaner2(int r) {
        int nc, nr;
        if (r == R - 1) {
            nr = r;
            nc = C - 1;
            while (nc > 0) {
                map[nr][nc] = map[nr][nc - 1];
                nc--;
            }
            map[r][1] = 0;
        } else {
            nr = r + 1;
            nc = 0;
            while (nr < R - 1) {
                map[nr][nc] = map[nr + 1][nc];
                nr++;
            }
            while (nc < C - 1) {
                map[nr][nc] = map[nr][nc + 1];
                nc++;
            }
            while (nr > r) {
                map[nr][nc] = map[nr - 1][nc];
                nr--;
            }
            while (nc > 0) {
                map[nr][nc] = map[nr][nc - 1];
                nc--;
            }
            map[r][1] = 0;
        }
    }

}
