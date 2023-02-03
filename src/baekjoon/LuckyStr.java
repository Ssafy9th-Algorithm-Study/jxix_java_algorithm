package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStr {

    static int ans = 0;
    static int [] counts = new int[26];
    static void check(String str, String input){
        if (str.length() == input.length()){
            ans++;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && str.charAt(str.length()-1)!=(char)('a'+i)){
                counts[i]--;
                check(str + (char)('a' +i), input);
                counts[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            int idx = (int)input.charAt(i)-'a';
            counts[idx]++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0){
                counts[i]--;
                check((char)('a' +i) + "", input);
                counts[i]++;
            }
        }
        System.out.println(ans);
    }
}
