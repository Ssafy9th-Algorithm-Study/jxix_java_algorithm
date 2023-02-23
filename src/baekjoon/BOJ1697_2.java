package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_2 {

    static boolean [] visited = new boolean[100001];

    static void bfs(int N, int K) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{N, 0});
        visited[N] = true;

        while(!q.isEmpty()){
            int now = q.peek()[0];
            int time = q.peek()[1];
            q.poll();
            if (now == K){
                System.out.println(time);
                break;
            }
            if (now-1>=0 && !visited[now-1]){
                visited[now-1]=true;
                q.offer(new int[]{now-1, time+1});
            }
            if (now+1<=100000 && !visited[now+1]){
                visited[now+1]=true;
                q.offer(new int[]{now+1, time+1});
            }
            if (now*2<=100000 && !visited[now*2]){
                visited[now*2]=true;
                q.offer(new int[]{now*2, time+1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bfs(N, K);
    }
}
