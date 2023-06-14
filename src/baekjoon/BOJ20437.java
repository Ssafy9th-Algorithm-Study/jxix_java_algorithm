package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ20437 {

    static List<Integer>[] characters = new ArrayList[28];

    private static int getShortestLength(int chIdx, int K) {
        int i = 0;
        int j = K-1;
        int minLength = Integer.MAX_VALUE;
        while (j < characters[chIdx].size()){
            if (minLength > (characters[chIdx].get(j) - characters[chIdx].get(i)) + 1){
                minLength = characters[chIdx].get(j) - characters[chIdx].get(i) + 1;
            }
            i++;j++;
        }
        return minLength;
    }

    private static int getLongestLength(int chIdx, int K) {
        int i = 0;
        int j = K-1;
        int maxLength= Integer.MIN_VALUE;
        while (j < characters[chIdx].size()){
            if (maxLength < (characters[chIdx].get(j) - characters[chIdx].get(i)) +1){
                maxLength = characters[chIdx].get(j) - characters[chIdx].get(i) + 1;
            }
            i++;j++;
        }
        return maxLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 28; i++) {
                characters[i] = new ArrayList<>();
            }
            for (int i = 0; i < W.length(); i++) {
                characters[W.charAt(i) - 'a'].add(i);
            }
            int ans1 = Integer.MAX_VALUE;
            int ans2 = Integer.MIN_VALUE;
            for (int i = 0; i < 28; i++) {
                if (characters[i].size() >= K) {
                    int result1 = getShortestLength(i, K);
                    int result2 = getLongestLength(i, K);
                    if (ans1 > result1) {
                        ans1 = result1;
                    }
                    if (ans2 < result2){
                        ans2 = result2;
                    }
                }
            }
            if (ans1 == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(ans1).append(" ").append(ans2).append("\n");
            }
        }
        System.out.print(sb);
    }
}
