package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1233. [S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
 */
public class SWEA1233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                 st = new StringTokenizer(br.readLine());
                 if (flag) {
                     if (st.countTokens() == 4) {
                         st.nextToken();
                         String op = st.nextToken();
                         if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))
                             continue;
                         sb.append("#").append(t).append(" ").append(0).append("\n");
                         flag = false;
                     } else {
                         st.nextToken();
                         String num = st.nextToken();
                         if (num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/")){
                             sb.append("#").append(t).append(" ").append(0).append("\n");
                             flag = false;
                         }
                     }
                 }
            }
            if (flag)
                sb.append("#").append(t).append(" ").append(1).append("\n");
        }
        System.out.print(sb);
    }
}
