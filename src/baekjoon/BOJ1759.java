package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static char[] characters;

    public static void solve(int vowels, int consonants, int idx, String str) {
        if (str.length() == L) {
            if (vowels >= 1 && consonants >= 2) {
                sb.append(str).append("\n");
            }
            return;
        }
        if (idx == C) {
            // 더 이상 선택할 수 있는 알파벳이 없다.
            return;
        }
        if (characters[idx] == 'a' || characters[idx] == 'e' || characters[idx] == 'i' || characters[idx] == 'o' || characters[idx] == 'u') {
            solve(vowels + 1, consonants, idx + 1, str + characters[idx]);
        } else {
            solve(vowels, consonants + 1, idx + 1, str + characters[idx]);
        }
        solve(vowels, consonants, idx + 1, str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        characters = new char[C];
        for (int i = 0; i < C; i++) {
            characters[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(characters);
        solve(0, 0, 0, "");
        System.out.print(sb);
    }
}
