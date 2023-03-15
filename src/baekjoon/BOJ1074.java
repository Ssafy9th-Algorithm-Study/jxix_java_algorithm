package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    static int count = 0;
    static int answer;
    static int R;
    static int C;
    private static void visit(int N, int r, int c) {
        if (r==R && c == C){
            answer = count;
            return;
        }
        if (N == 0)
            return;
        if (R < r+N) {
            if (C < c+N){
                visit(N/2, r, c);
            }
            else {
                count += N * N;
                visit(N/2, r, c + N);
            }
        } else {
            if (C < c+N){
                count += N * N * 2;
                visit(N/2, r+ N, c );
            }
            else {
                count += N * N * 3;
                visit(N/2, r+ N, c+ N);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit(1 << N, 0,0);
        System.out.println(answer);
    }
}
