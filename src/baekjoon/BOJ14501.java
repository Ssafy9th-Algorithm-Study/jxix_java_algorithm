package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14501 {

    static int[] times;
    static int[] profits;
    static int maxProfit;

    static void calcProfit(int curDate, int curProfit, int N){
        if (curDate > N)
            return;
        if (maxProfit < curProfit)
            maxProfit = curProfit;
        if (curDate == N)
            return;
        calcProfit(curDate + times[curDate], curProfit + profits[curDate], N);
        calcProfit(curDate + 1, curProfit, N);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        times = new int[N];
        profits = new int[N];
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            times[i] = Integer.parseInt(inputs[0]);
            profits[i] = Integer.parseInt(inputs[1]);
        }
        calcProfit(0,0,N);
        System.out.println(maxProfit);
    }
}
