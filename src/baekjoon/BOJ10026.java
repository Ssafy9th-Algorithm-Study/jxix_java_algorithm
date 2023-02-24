package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10026 {

    static boolean[][] visited;
    static int N;
    static char [][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, char current) {
        visited[x][y] = true;
        for (int i = 0; i <4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && (map[nx][ny] == current)){
                dfs(nx, ny, current);
            }
        }
    }
    static void redGreendfs(int x, int y, char current) {
        visited[x][y] = false;
        for (int i = 0; i <4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && visited[nx][ny]){
                if (current == 'R' || current == 'G'){
                    if (map[nx][ny]=='R' || map[nx][ny]=='G'){
                        redGreendfs(nx, ny, current);
                    }
                } else {
                    if (map[nx][ny]=='B'){
                        redGreendfs(nx, ny, current);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i <N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        char[] colors = {'R', 'G', 'B'};
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == colors[i] && !visited[j][k]){
                        dfs(j, k, colors[i] );
                        count++;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder().append(count).append(" ");
        count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == colors[i] && visited[j][k]){
                        redGreendfs(j,k,colors[i]);
                        count++;
                    }
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}
