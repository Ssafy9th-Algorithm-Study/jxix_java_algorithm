package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = Math.min(N, M) / 2;
        while(R-- > 0){
            int col = M-1;
            int row = N-1;
            for (int i = 0; i < cnt; i++) {
                int tmp = arr[i][i];
                for (int j = i; j < col; j++) {
                    arr[i][j] = arr[i][j + 1];
                }
                for (int j = i; j < row; j++) {
                    arr[j][col] = arr[j + 1][col];
                }
                for (int j = col; j > i; j--) {
                    arr[row][j] = arr[row][j-1];
                }
                for (int j = row; j >i; j--) {
                    arr[j][i] = arr[j-1][i];
                }
                arr[i+1][i] = tmp;
                col--; row--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
