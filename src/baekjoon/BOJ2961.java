package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {

    static int ans = Integer.MAX_VALUE;
    static int [] sour;
    static int [] bitter;
    private static void getSubSet(int idx, int N, int sourSum, int bitterSum) {
        if (idx == N){
            if (bitterSum > 0) {
                int diff = sourSum > bitterSum ? sourSum - bitterSum : bitterSum - sourSum;
                if (diff < ans)
                    ans = diff;
            }
            return;
        }
        getSubSet(idx+1,  N, sourSum * sour[idx], bitterSum + bitter[idx]);
        getSubSet(idx+1,  N, sourSum, bitterSum);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        sour = new int[N];
        bitter = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        getSubSet(0,N,1,0);
        System.out.println(ans);
    }
}
