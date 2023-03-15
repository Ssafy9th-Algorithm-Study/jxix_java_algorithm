package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816 {

    static int[] arr;
    private static int lowerBound(int start, int end, int target){
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    private static int upperBound(int start, int end, int target){
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upperBound(0, N, target) - lowerBound(0, N, target)).append(" ");
        }
        System.out.println(sb);
    }
}
