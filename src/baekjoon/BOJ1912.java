package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N ; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i-1] + dp[i], dp[i]);
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(max);
    }
}
