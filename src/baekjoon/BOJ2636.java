package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {

    static boolean [][] visited;
    static int R,C;
    static char [][] map;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};

    static int bfs() {
        visited = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int [] current;
        int nx, ny;
        int count = 0;
        while(!queue.isEmpty()){
            current = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = current[0] + dx[i];
                ny = current[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    if (map[nx][ny] == '0'){
                        queue.offer(new int[]{nx,ny});
                    } else {
                        map[nx][ny] = '0';
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int cheese = 0;
        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == '1')
                    cheese++;
            }
        }
        while (cheese > 0){
            cnt++;
            answer = bfs();
            cheese-= answer;
        }
        System.out.println(cnt);
        System.out.println(answer);
    }
}
