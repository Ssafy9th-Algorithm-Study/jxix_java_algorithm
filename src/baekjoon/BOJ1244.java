package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1244 {
    public static void changeSwitch(int gender, int num, int N, String[] status){
        if (gender == 1){
            for (int i=(num-1);i<N;i+=num){
                if (status[i].equals("1"))
                    status[i] = "0";
                else
                    status[i] = "1";
            }
        } else {
            int start = num-1;
            int end = num-1;
            while(start >=0 && end < N) {
                if (!status[start].equals(status[end]))
                    break;
                start--;
                end++;
            }
            for (int i = start+1; i < end; i++) {
                if (status[i].equals("1"))
                    status[i] = "0";
                else
                    status[i] = "1";
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] status = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] inputs = br.readLine().split(" ");
            int gender = Integer.parseInt(inputs[0]);
            int num = Integer.parseInt(inputs[1]);
            changeSwitch(gender,num, N, status);
        }
        int count = 0;
        for (int i = 0; i < status.length; i++) {
            System.out.print(status[i] + " ");
            count++;
            if (count == 20){
                System.out.println();
                count = 0;
            }
        }
    }
}
