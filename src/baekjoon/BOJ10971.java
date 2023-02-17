package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** BOJ 10971: 외판원 순회 2 **/
public class BOJ10971 {

    static int minCost = Integer.MAX_VALUE;
    static int[][] W;
    public static void tsp(int cnt, int N, boolean[] visited, int[] selected) {
        if (cnt == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                int startIdx = selected[i];
                int endIdx = selected[i + 1];
                if (W[startIdx][endIdx] == 0) {
                    sum = 0;
                    break;
                }
                sum += W[startIdx][endIdx];
            }
            if (sum == 0 || W[selected[N - 1]][selected[0]] == 0) {
                return;
            }
            sum += W[selected[N - 1]][selected[0]];
            if (minCost > sum) {
                minCost = sum;
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[cnt] = i;
                tsp(cnt + 1, N, visited, selected);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tsp(0, N, new boolean[N], new int[N]);
        System.out.println(minCost);
    }
}
