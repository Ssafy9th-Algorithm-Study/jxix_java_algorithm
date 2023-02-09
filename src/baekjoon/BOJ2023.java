package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2023 {

    static StringBuilder sb = new StringBuilder();
    static void makePrime(int num, int N, int cnt) {
        if (cnt==N){
            sb.append(num);
            sb.append("\n");
            return;
        }
        for (int i=1;i<10;i+=2){
            if (isPrime(num*10 + i)){
                makePrime(num*10 + i, N,cnt+1);
            }
        }
    }
    static boolean isPrime(int num) {
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] prime = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            makePrime(prime[i], N, 1);
        }
        System.out.print(sb);
    }
}
