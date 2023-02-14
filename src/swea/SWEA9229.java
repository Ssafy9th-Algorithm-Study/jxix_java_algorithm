package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {

    static int ans;
    static int N;
    static int M;
    static int [] snacks;
    static void getSnacks(int idx, int cnt, int sum) {
        if (cnt == 2) {
            if (ans < sum && sum <= M)
                ans = sum;
            return;
        }
        if (idx >= N)
            return;
        getSnacks(idx+1, cnt+1, sum+snacks[idx]);
        getSnacks(idx+1, cnt, sum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= TC; t++) {
            ans = -1;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snacks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                snacks[i] = Integer.parseInt(st.nextToken());
            }
            getSnacks(0, 0, 0);
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
