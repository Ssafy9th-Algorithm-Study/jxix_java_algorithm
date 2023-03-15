package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {

    static int K;
    static long [] lines;
    private static long getCount(long mid) {
        long count = 0;
        for (int i = 0; i < K; i++) {
            count += (lines[i] / mid);
        }
        return count;
    }
    private static long upperBound(long start, long end, int target) {
        while (start < end) {
            long mid = (start + end + 1) / 2;
            if (getCount(mid) < target)
                end = mid - 1;
            else
                start = mid;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        lines = new long[K];
        long maxLine = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            if (maxLine < lines[i])
                maxLine = lines[i];
        }
        System.out.println(upperBound(0, maxLine+1, N));
    }
}
