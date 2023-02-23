package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[100001];
        for (int i = 0; i <= K; i++) {
            dp[i] = Math.abs(N - i);
        }
        if (N < K) {
            for (int i = N+1; i <= K; i++) {
                if (i%2==0){
                    //짝수인 경우는 그 전 위치에서 순간이동하는 것이 제일 빠르다.
                    dp[i] = Math.min(dp[i/2] + 1, dp[i]);
                } else{
                    //홀수는 -1칸에서 +1 또는 앞칸에서 +1
                    dp[i] = Math.min(dp[(i+1)/2]+2,dp[(i-1)/2]+2);
                }
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
        }
        System.out.println(dp[K]);
    }
}
