package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** SWEA 2001: 파리 퇴치 **/
public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#");
            sb.append(t);
            sb.append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] nums = new int[N][N];
            int[][] sums = new int[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    nums[i][j] = Integer.parseInt(st.nextToken());
                    sum += nums[i][j];
                    sums[i + 1][j + 1] = sum;
                }
            }
            for (int i = 1; i <= N; i++) {
                int sum = 0;
                for (int j = 1; j <= N; j++) {
                    sum += sums[j][i];
                    sums[j][i] = sum;
                }
            }
            // i,j 에서 i + M, j+ M 합
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = sums[i + M][j + M] + sums[i][j] - sums[i + M][j] - sums[i][j + M];
                    if (sum > maxSum)
                        maxSum = sum;
                }
            }
            sb.append(maxSum);
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
