package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            sb.append(origin.charAt(i));
            if (sb.length() >= bomb.length()) {
                int j;
                for (j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != sb.charAt(sb.length() - bomb.length() + j)) {
                        break;
                    }
                }
                if (j == bomb.length()) {
                    sb.delete(sb.length() - bomb.length(), sb.length());
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("FRULA");
        }
        System.out.println(sb);
    }
}
