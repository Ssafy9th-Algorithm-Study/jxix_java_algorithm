package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] paper = new boolean[100][100];
        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a-1; j <a+9 ; j++) {
                for (int k = 90 - b; k < 100 -b; k++) {
                    if (!paper[j][k]){
                        paper[j][k] = true;
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
