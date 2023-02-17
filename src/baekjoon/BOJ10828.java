package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if (input.equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (input.equals("pop")){
                if (!stack.isEmpty()){
                    sb.append(stack.pop()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            } else if (input.equals("size")) {
                sb.append(stack.size()).append("\n");
            } else if (input.equals("empty")){
                int ans = stack.isEmpty() ? 1 : 0;
                sb.append(ans).append("\n");
            } else {
                if (!stack.isEmpty()){
                    sb.append(stack.peek()).append("\n");
                } else {
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
