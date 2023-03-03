package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> keyNumbers = new HashMap<>();
        HashMap<String, Integer> keyNames = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String input =br.readLine();
            keyNumbers.put(i, input);
            keyNames.put(input, i);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (keyNames.containsKey(input)){
                sb.append(keyNames.get(input)).append("\n");
            } else {
                sb.append(keyNumbers.get(Integer.parseInt(input))).append("\n");
            }
        }
        System.out.print(sb);
    }
}
