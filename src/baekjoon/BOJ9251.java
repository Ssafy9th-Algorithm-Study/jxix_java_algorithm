package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        String Y = br.readLine();
        int [][] LCS = new int[X.length()+1][Y.length()+1];
        for (int i = 0; i <= X.length(); i++) {
            LCS[i][0] = 0;
        }
        for (int i = 0; i <= Y.length(); i++) {
            LCS[0][i] = 0;
        }
        for (int i = 1; i <= X.length(); i++) {
            for (int j = 1; j <= Y.length(); j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)){
                    LCS[i][j] = LCS[i-1][j-1] +1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        System.out.println(LCS[X.length()][Y.length()]);
    }
}
