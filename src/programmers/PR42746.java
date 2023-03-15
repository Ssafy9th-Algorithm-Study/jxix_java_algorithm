package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PR42746 {
    public static void main(String[] args) {
        PR42746 pr42746 = new PR42746();
        System.out.println(pr42746.solution(new int[]{6, 10, 2}));
        System.out.println(pr42746.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(pr42746.solution(new int[]{0, 0, 0, 0, 0, 0}));
    }

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = numbers[i] + "";
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.charAt(0) == o2.charAt(0)) {
                    return (o2 + o1).compareTo(o1 + o2);
                }
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        if (sb.toString().charAt(0) == '0')
            return "0";
        return sb.toString();
    }
}
