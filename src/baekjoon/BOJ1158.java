package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            for (int i = 1; i < K; i++) {
                int tmp = queue.poll();
                queue.offer(tmp);
            }
            sb.append(queue.poll());
            if (!queue.isEmpty())
                sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
