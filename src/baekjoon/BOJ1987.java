package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {-1,1, 0, 0}; //상하좌우
    static int[] dy = {0, 0, -1, 1};
    static int R, C;
    static int ans;
    static int count;

    private static void solve(int x, int y) {
        count++;
        visited[map[x][y]-'A'] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx<R && ny<C && !visited[map[nx][ny]-'A']){
                solve(nx, ny);
            }
        }
        visited[map[x][y]-'A'] = false;
        if (ans < count)
            ans = count;
        count--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        solve(0, 0);
        System.out.println(ans);
    }
}
