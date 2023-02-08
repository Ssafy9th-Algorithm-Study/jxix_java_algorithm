package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11659 {
    static int [] sums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        sums = new int[N];
        int[] nums = new int[N];
        inputs = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i <N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
            sum += nums[i];
            sums[i] = sum;
        }
        for (int i = 0; i < M; i++) {
            inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            if (start == 1)
                sb.append(sums[end - 1]);
            else {
                sb.append(sums[end-1] - sums[start - 2]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
