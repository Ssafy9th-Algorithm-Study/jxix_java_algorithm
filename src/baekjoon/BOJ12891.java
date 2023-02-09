package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int [] counts = new int[26];
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[4];
        int[] indexs = {0, 2, 6, 19};
        for (int i = 0; i < 4; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int startIdx = 0;
        int endIdx = P;
        for (int i = startIdx; i < endIdx; i++) {
            int idx = (int) dna.charAt(i) - 'A';
            counts[idx]++;
        }
        while (endIdx <= S) {
            boolean flag = true;
            for (int i=0;i<4;i++){
                if (counts[indexs[i]] < nums[i]) {
                    flag = false;
                }
            }
            if(flag)
                ans++;
            if (endIdx == S)
                break;
            counts[dna.charAt(startIdx++) - 'A']--;
            counts[dna.charAt(endIdx++) - 'A']++;
        }
        System.out.println(ans);
    }
}
