package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17406 {

    static int N, M, K;
    static boolean[] isSelected;
    static int[] indexes;
    static Point[] points;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;

    private static class Point {
        int startX, startY;
        int endX, endY;

        public Point(int r, int c, int s) {
            this.startX = r - s - 1;
            this.startY = c - s - 1;
            this.endX = r + s - 1;
            this.endY = c + s - 1;
        }
    }

    private static void getPermutation(int cnt) {
        if (cnt == K) {
            int result = getRotateResult();
            if (ans > result)
                ans = result;
            return;
        }
        for (int i = 0; i < K; i++) {
            if (isSelected[i])
                continue;
            indexes[cnt] = i;
            isSelected[i] = true;
            getPermutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static int getRotateResult() {
        int[][] copymap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copymap[i], 0, map[i].length);
        }
        for (int i = 0; i < K; i++) {
            Point p = points[indexes[i]];
            int cnt = (p.endX - p.startX + 1) / 2;
            int endY = p.endY;
            int endX = p.endX;
            int startX = p.startX;
            int startY = p.startY;
            while (cnt-- > 0) {
                int tmp = copymap[startX][endY];
                for (int k = endY; k > startY; k--) {
                    copymap[startX][k] = copymap[startX][k - 1];
                }
                for (int k = startX; k < endX; k++) {
                    copymap[k][startY] = copymap[k + 1][startY];
                }
                for (int k = startY; k < endY; k++) {
                    copymap[endX][k] = copymap[endX][k + 1];
                }
                for (int k = endX; k > startX; k--) {
                    copymap[k][endY] = copymap[k - 1][endY];
                }
                copymap[startX + 1][endY] = tmp;
                startX++;
                startY++;
                endX--;
                endY--;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += copymap[i][j];
            }
            if (min > sum)
                min = sum;
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isSelected = new boolean[K];
        indexes = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        points = new Point[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        getPermutation(0);
        System.out.println(ans);
    }
}
