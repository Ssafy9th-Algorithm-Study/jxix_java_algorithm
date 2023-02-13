package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> idxs = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && tmp > stack.peekLast()) {
                stack.pollLast();
                idxs.pollLast();
            }
            if (stack.isEmpty())
                sb.append(0).append(" ");
            else
                sb.append(idxs.peekLast()).append(" ");
            stack.offerLast(tmp);
            idxs.offerLast(i);
        }
        System.out.println(sb);
    }
}
