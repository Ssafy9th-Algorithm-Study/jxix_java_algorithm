package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1937 {
    static int [][] map;
    static int [][] dp;
    static int N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = Integer.MIN_VALUE;

    static int dfs(int x, int y){
        dp[x][y]=1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[x][y] < map[nx][ny]){
                if (dp[nx][ny] == -1){
                    dp[x][y] = Math.max(dfs(nx, ny)+1, dp[x][y]);
                } else {
                    dp[x][y] =  Math.max(dp[nx][ny]+1, dp[x][y]);
                }
            }
        }
        answer = Math.max(dp[x][y], answer);
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i <N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j]==-1){
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
