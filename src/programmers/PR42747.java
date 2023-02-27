package programmers;

import java.util.Arrays;

public class PR42747 {
    public static void main(String[] args) {
        PR42747 pr42747 = new PR42747();
        System.out.println(pr42747.solution(new int[]{3, 0, 6, 1, 5}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int left = 0;
        int right = 10000;
        while(left<right){
            int mid = (left+right+1)/2;
            if ((Arrays.binarySearch(citations, mid) + citations.length +1) >= mid){
                if (answer < mid){
                    answer = mid;
                }
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }
}
