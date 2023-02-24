package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        long min = Long.MAX_VALUE;
        long[] answer = new long[2];
        while (start < end) {
            long sum = arr[end] + arr[start];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[start];
                answer[1] = arr[end];
            }
            if (sum > 0){
                end--;
            } else {
                start++;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}
