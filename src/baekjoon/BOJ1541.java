package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int result = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == '+' || input.charAt(i) == '-') {
                if (flag) {
                    result -= Integer.parseInt(sb.toString());
                } else {
                    result += Integer.parseInt(sb.toString());
                }
                if (i == input.length())
                    break;
                sb = new StringBuilder();
                if (input.charAt(i) == '-')
                    flag = true;
            } else {
                sb.append(input.charAt(i));
            }
        }
        System.out.println(result);
    }
}
