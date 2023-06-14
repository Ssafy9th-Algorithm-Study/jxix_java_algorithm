package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2239 {

    static int [][] arr = new int[9][9];
    static boolean [][] row = new boolean[9][9];
    static boolean [][] col = new boolean[9][9];
    static boolean [][] square = new boolean[9][9];
    static StringBuilder sb = new StringBuilder();

    private static void sudoku(int cnt){
        if (cnt == 81){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        int i = cnt / 9;
        int j = cnt % 9;
        if (arr[i][j]==0){
            for (int k = 0; k < 9; k++) {
                if (!row[i][k] && !col[j][k] && !square[(i/3)*3+(j/3)][k]){
                    arr[i][j] = k+1;
                    row[i][k] = true;
                    col[j][k] = true;
                    square[(i/3)*3+(j/3)][k] = true;
                    sudoku(cnt+1);
                    arr[i][j] = 0;
                    row[i][k] = false;
                    col[j][k] = false;
                    square[(i/3)*3+(j/3)][k] = false;
                }
            }
        } else {
            sudoku(cnt+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = input.charAt(j)-'0';
                if (arr[i][j] != 0){
                    row[i][arr[i][j]-1] = true;
                    col[j][arr[i][j]-1] = true;
                    square[(i/3)*3+(j/3)][arr[i][j]-1] = true;
                }
            }
        }
        sudoku(0);
    }
}

