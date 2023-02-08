package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** BOJ 15651: N과 M (3)**/
public class BOJ15651 {
    static int N;
    static int M;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void backtracking(int count, String s) {
        if (count == M) {
            sb.append(s);
            sb.append("\n");
            return;
        }
        for (int i=0;i<N;i++){
            backtracking(count+1,s + (i+1) + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        visited = new boolean[N];
        backtracking(0,"");
        System.out.print(sb);
    }
}
