package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14889 {

    static int[][] power;
    static boolean[] visited;
    static int minDiff = 100;

    static void power(int idx, int count, int N) {
        if (count == N / 2) {
            //능력치
            int startSum = 0;
            int linkSum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (visited[i] && visited[j]) {
                        startSum += power[i][j];
                        startSum += power[j][i];
                    }
                    if (!visited[i] && !visited[j]) {
                        linkSum += power[i][j];
                        linkSum += power[j][i];
                    }
                }
            }
            int diff;
            if (linkSum > startSum)
                diff = linkSum - startSum;
            else
                diff = startSum - linkSum;
            if (minDiff > diff)
                minDiff = diff;
            return;
        }
        if (idx >= N)
            return;

        visited[idx] = true;
        power(idx + 1, count + 1, N);

        visited[idx] = false;
        power(idx + 1, count, N);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                power[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        power(0, 0, N);
        System.out.println(minDiff);
    }
}
