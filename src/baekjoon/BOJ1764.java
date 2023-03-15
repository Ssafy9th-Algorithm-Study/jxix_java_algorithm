package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> notHear = new HashSet<>();
        for (int i = 0; i < N; i++) {
            notHear.add(br.readLine());
        }
        List<String> notHearNotSee = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (notHear.contains(name)){
                notHearNotSee.add(name);
            }
        }
        Collections.sort(notHearNotSee);
        sb.append(notHearNotSee.size()).append("\n");
        for (String name: notHearNotSee) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
