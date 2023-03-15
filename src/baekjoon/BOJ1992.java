package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {

    static int N;
    static int [][] map;
    static StringBuilder sb = new StringBuilder();

    private static void solve(int row, int col, int width){
        // row, col은 탐색할 공간의 좌측상단 시작점
        int sum = 0;
        for (int i = row; i < row+ width; i++) {
            for (int j = col; j < col + width; j++) {
                sum += map[i][j];
            }
        }
        if (sum == 0){
            sb.append("0");
            return;
        }
        if (sum == width * width){
            sb.append("1");
            return;
        }
        sb.append("(");
        solve(row, col, width / 2);
        solve(row, col + width / 2, width / 2);
        solve(row + width / 2, col, width / 2);
        solve(row + width / 2, col + width / 2, width / 2);
        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j <N; j++) {
                map[i][j] = input.charAt(j)-'0';
            }
        }
        solve(0, 0, N);
        System.out.println(sb);
    }
}
