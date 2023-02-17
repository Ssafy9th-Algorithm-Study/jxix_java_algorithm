package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15686 {

    static int minChickenStreet = Integer.MAX_VALUE;
    // 전체 치킨집
    static List<ChickenStore> chickenStores = new ArrayList<>();
    // 선택된 치킨집
    static ChickenStore[] selectedStore;
    static int N, M;
    static int[][] map;

    private static void getCombination(int cnt, int idx) {
        if (cnt == M) {
            int chickenStreet = calcStreet();
            if (minChickenStreet > chickenStreet)
                minChickenStreet = chickenStreet;
            return;
        }
        for (int i = idx; i < chickenStores.size(); i++) {
            selectedStore[cnt] = chickenStores.get(i);
            getCombination(cnt + 1, i + 1);
        }
    }

    private static class ChickenStore {
        int row;
        int col;

        public ChickenStore(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int getMinDistance(int x, int y) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            int dist = Math.abs(selectedStore[i].row - x) + Math.abs(selectedStore[i].col - y);
            if (min > dist)
                min = dist;
        }
        return min;
    }

    private static int calcStreet() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    sum += getMinDistance(i, j);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selectedStore = new ChickenStore[M];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickenStores.add(new ChickenStore(i, j));
                }
            }
        }
        getCombination(0, 0);
        System.out.println(minChickenStreet);
    }
}
