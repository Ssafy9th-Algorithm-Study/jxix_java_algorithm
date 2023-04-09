package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int [] visited = new int[d+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (visited[arr[i]] == 0){
                count++;
            }
            visited[arr[i]]++;
        }
        int result = count;
        for (int i = 0; i < N; i++) {
            if (visited[c] == 0){
                result = Math.max(result, count+1);
            } else {
                result = Math.max(result, count);
            }
            if (--visited[arr[i]] == 0){
                count--;
            }
            if (visited[arr[(i+k)%N]]++ == 0){
                count++;
            }
        }
        System.out.println(result);
    }
}
