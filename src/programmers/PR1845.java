package programmers;

import java.util.HashSet;
import java.util.Set;

public class PR1845 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int answer = nums.length/2;
        if (set.size() < nums.length/2) {
            answer = set.size();
        }
        return answer;
    }
}
