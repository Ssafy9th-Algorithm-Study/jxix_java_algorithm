package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            boolean curDir = true;
            boolean isErrorOccur = false;
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine().replace("[", "").replace("]",""), ",");
            for (int j = 0; j < n; j++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == 'R'){
                    curDir = !curDir;
                } else {
                    // true면 앞에꺼 버리기, false면 뒤에꺼 버리기.
                    if (curDir) {
                        if (deque.isEmpty()){
                            sb.append("error\n");
                            isErrorOccur = true;
                            break;
                        } else {
                            deque.pollFirst();
                        }
                    } else {
                        if (deque.isEmpty()){
                            sb.append("error\n");
                            isErrorOccur = true;
                            break;
                        } else
                            deque.pollLast();
                    }
                }
            }
            if (!isErrorOccur){
                sb.append("[");
                while(!deque.isEmpty()){
                    if (curDir){
                        sb.append(deque.pollFirst());
                    } else {
                        sb.append(deque.pollLast());
                    }
                    if (deque.isEmpty())
                        break;
                    sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
