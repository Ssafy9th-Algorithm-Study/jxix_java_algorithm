package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] budgetRequests = new int[N];
        int maxRequest = 0;
        for (int i = 0; i < N; i++) {
            budgetRequests[i] = Integer.parseInt(st.nextToken());
            if (maxRequest < budgetRequests[i])
                maxRequest = budgetRequests[i];
        }
        long M = Long.parseLong(br.readLine());
        long start = 0;
        long end = maxRequest +1;
        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i <N; i++) {
                sum += Math.min(mid, budgetRequests[i]);
            }
            if (sum <= M) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        System.out.println(end-1);
    }
}
