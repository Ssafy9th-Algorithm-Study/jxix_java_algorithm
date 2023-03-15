package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int x;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x != 0){
                pq.add(x);
            } else {
                if (!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
