package baekjoon;

import java.util.*;

public class ConferenceRoom {

    int startTime;
    int endTime;

    public ConferenceRoom(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ConferenceRoom[] conferenceRooms = new ConferenceRoom[N];
        int start, end;
        for (int i = 0; i < N; i++) {
            start = sc.nextInt();
            end = sc.nextInt();
            conferenceRooms[i] = new ConferenceRoom(start, end);
        }

        Arrays.sort(conferenceRooms, (o1, o2) -> {
            if (o1.endTime == o2.endTime){
                return o1.startTime - o2.startTime;
            }
            return o1.endTime - o2.endTime;
        });
        int currentTime = conferenceRooms[0].endTime;
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (conferenceRooms[i].startTime >= currentTime){
                count++;
                currentTime = conferenceRooms[i].endTime;
            }
        }
        System.out.println(count);
    }

}
