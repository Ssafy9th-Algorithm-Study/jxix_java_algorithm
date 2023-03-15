package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {

    static int [][] map;
    static int whiteNum;
    static int blueNum;

    private static void cut(int N, int r, int c) {
        int sum = 0;
        for (int i = r; i < r+N; i++) {
            for (int j = c; j < c+N; j++) {
                sum += map[i][j];
            }
        }
        if (sum == 0){
            whiteNum++;
        } else if (sum == N*N){
            blueNum++;
        } else {
            cut(N / 2, r, c);
            cut(N / 2, r + N / 2, c);
            cut(N / 2, r, c+ N / 2);
            cut(N / 2, r + N / 2, c+ N / 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(N,0,0);
        System.out.println(whiteNum);
        System.out.println(blueNum);
    }
}
