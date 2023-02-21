package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    static int X;
    static int Y;

    private static int getWinRate(int mid) {
        return (int) ((long) (Y + mid) * 100 / (X + mid));
    }

    public static int binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (getWinRate(mid) > target) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int Z = getWinRate(0);
        if (Z >= 99)
            System.out.println(-1);
        else {
            System.out.println(binarySearch(0, 1000000000, Z));
        }

    }
}
