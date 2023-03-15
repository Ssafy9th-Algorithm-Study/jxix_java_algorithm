package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109 {

    static int answer;
    static boolean flag;
    static int R, C;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static char[][] map;

    private static void dfs(int x, int y) {
        if (y == C - 1) {
            answer++;
            flag = true;
            return;
        }
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'x') {
                if (!flag) {
                    map[nx][ny] = 'x';
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(answer);
    }
}
