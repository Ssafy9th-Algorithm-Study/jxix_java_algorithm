package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ13750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] A = new int[N];
        int [] low = new int[N];
        int [] high = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
            low[i] = 1;
            high[i] = 1;
        }
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < k; j++) {
                if (A[j] > A[k])
                    low[k] = Math.max(low[k], high[j] + 1);
                if (A[j] < A[k])
                    high[k] = Math.max(high[k], low[j] + 1);
            }
        }
        System.out.println(Math.max(low[N-1], high[N-1]));
    }
}
