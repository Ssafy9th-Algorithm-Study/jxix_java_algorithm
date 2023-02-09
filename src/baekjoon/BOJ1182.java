package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int ans;
    static int [] nums;
    private static void getPartialSum(int idx, int N, int S, int cnt, int sum) {
        if (idx == N) {
            if (sum == S && cnt != 0) {
                ans++;
            }
            return;
        }
        getPartialSum(idx+1, N, S, cnt+1, sum+nums[idx]);
        getPartialSum(idx+1, N, S, cnt, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        getPartialSum(0, N, S, 0, 0);
        System.out.println(ans);
    }
}
