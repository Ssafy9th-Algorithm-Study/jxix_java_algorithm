package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** BOJ 15650: N과 M (2)**/
public class BOJ15650 {

    static int N;
    static int M;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void backtracking(int idx, int count) {
        if (count == M) {
            for (int i = 0; i < N; i++) {
                if (visited[i]){
                    sb.append(i+1);
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        if (idx >= N)
            return;
        visited[idx] = true;
        backtracking(idx+1, count+1);
        visited[idx] = false;
        backtracking(idx+1,count);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        visited = new boolean[N];
        backtracking(0,0);
        System.out.print(sb);
    }
}
