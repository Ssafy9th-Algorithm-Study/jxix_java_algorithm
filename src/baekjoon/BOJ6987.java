package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6987 {

    static int answer;
    static int[][] scores;
    static int[] hometeam;
    static int[] awayteam;

    private static void solve(int count) {
        if (count == 15) {
            answer = 1;
            return;
        }

        int i = hometeam[count];
        int j = awayteam[count];

        if (scores[i][0] > 0 && scores[j][2] > 0) {
            // 홈팀 승리
            scores[i][0]--;
            scores[j][2]--;
            solve(count + 1);
            scores[i][0]++;
            scores[j][2]++;
        }

        if (scores[i][1] > 0 && scores[j][1] > 0) {
            // 무승부
            scores[i][1]--;
            scores[j][1]--;
            solve(count + 1);
            scores[i][1]++;
            scores[j][1]++;
        }

        if (scores[i][2] > 0 && scores[j][0] > 0) {
            // 원정팀 승리
            scores[i][2]--;
            scores[j][0]--;
            solve(count + 1);
            scores[i][2]++;
            scores[j][0]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        scores = new int[6][3];
        hometeam = new int[15];
        awayteam = new int[15];
        int idx = 0;

        // 대진표 짜기
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                hometeam[idx] = i;
                awayteam[idx++] = j;
            }
        }

        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            answer = 0;
            boolean flag = true;
            // 만약 한 팀이 경기를 5번하지 않았으면 무조건 불가능
            for (int i = 0; i < 6; i++) {
                int sum = 0;
                for (int j = 0; j < 3; j++) {
                    scores[i][j] = Integer.parseInt(st.nextToken());
                    sum += scores[i][j];
                }
                if (sum != 5)
                    flag = false;
            }
            if (flag)
                solve(0);
            System.out.println(answer);
        }
    }
}
