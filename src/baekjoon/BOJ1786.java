package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1786 {
    static int[] pi;
    static int count;
    static StringBuilder sb = new StringBuilder();
    private static void makePi(String pattern) {
        pi = new int[pattern.length()];
        int i = 0;
        int j = 1;
        pi[0] = 0;
        while (j < pattern.length()) {
            if (pattern.charAt(i) != pattern.charAt(j)) {
                if (i == 0) {
                    pi[j] = 0;
                    j++;
                } else {
                    i = pi[i - 1];
                }
            } else {
                pi[j] = i + 1;
                i++;
                j++;
            }
        }
    }

    public static void kmpSearch(String str, String pattern) {
        makePi(pattern);
        int i = 0;
        int j = 0;
        while(i <= str.length()) {
            if (j == pattern.length()){
                count++;
                sb.append(i-j+1).append(" ");
                j = pi[j - 1];
            }
            if (i == str.length())
                break;
            if (str.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            } else {
                if (j == 0){
                    i++;
                    continue;
                }
                j = pi[j-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        kmpSearch(br.readLine(), br.readLine());
        System.out.println(count);
        System.out.println(sb);
    }
}
