package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        boolean[] isNotDwarf = new boolean[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if ((arr[i] + arr[j]) == (sum - 100)) {
                    isNotDwarf[i] = true;
                    isNotDwarf[j] = true;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (!isNotDwarf[i])
                sb.append(arr[i]).append("\n");
        }
        System.out.print(sb);
    }
}
