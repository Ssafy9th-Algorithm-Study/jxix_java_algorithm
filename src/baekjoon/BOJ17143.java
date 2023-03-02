package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17143 {

    static class Shark {
        int row;
        int col;
        int size;
        int velocity;
        int direction;

        public Shark(int row, int col, int size, int velocity, int direction) {
            this.row = row;
            this.col = col;
            this.size = size;
            this.velocity = velocity;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int answer = 0;
        int r, c, s, d, z;
        int M = Integer.parseInt(st.nextToken());
        Shark[] sharks = new Shark[M+1];
        boolean [] isDead = new boolean[M+1];
        int[][] map = new int[R+1][C+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, z, s, d);
            map[r][c] = i;
        }
        for (int i = 1; i <= C; i++) {
            //상어를 돌면서 살아 있는 상어 중 가장 가까운 상어를 찾는다.
            for (int j = 1; j <= R; j++) {
                if (map[j][i] != 0){
                    answer += sharks[map[j][i]].size;
                    isDead[map[j][i]] = true;
                    map[j][i] = 0;
                    break;
                }
            }
            //상어가 이동한다.
            for (int j = 1; j <= M; j++) {
                if (!isDead[j]){
                    //살아있는 상어만 이동
                    if (sharks[j].direction == 1) {
                        int dist = sharks[j].velocity + (R - sharks[j].row);
                        if ((dist / (R - 1)) % 2 == 0) {
                            //짝수면 방향 그대로
                            //원래 위치 삭제 후 상어에 새로운 위치 저장
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].row = R - dist % (R - 1);
                        } else {
                            //홀수면 방향 반대로
                            sharks[j].direction = 2;
                            //원래 위치 삭제 후 상어에 새로운 위치 저장
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].row = (dist % (R - 1)) + 1;
                        }
                    } else if (sharks[j].direction == 2) {
                        int dist = sharks[j].velocity + sharks[j].row - 1;
                        if ((dist / (R-1)) % 2 == 0){
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].row = dist % (R-1) + 1;
                        } else {
                            sharks[j].direction = 1;
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].row = R - (dist % (R-1));
                        }
                    } else if (sharks[j].direction == 3){
                        int dist = sharks[j].velocity + sharks[j].col - 1;
                        if ((dist / (C-1)) % 2 == 0){
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].col = dist % (C-1) + 1;
                        } else {
                            sharks[j].direction = 4;
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].col = C - (dist % (C-1));
                        }
                    } else {
                        int dist = sharks[j].velocity + (C - sharks[j].col);
                        if ((dist / (C-1)) % 2 == 0){
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].col = C - dist % (C-1);
                        } else {
                            sharks[j].direction = 3;
                            map[sharks[j].row][sharks[j].col] = 0;
                            sharks[j].col = (dist % (C-1)) + 1;
                        }
                    }
                }
            }

            for (int j = 1; j <= M; j++) {
                if (!isDead[j]){
                    if (map[sharks[j].row][sharks[j].col] != 0){
                        if (sharks[map[sharks[j].row][sharks[j].col]].size > sharks[j].size) {
                            // 원래 있는 상어에게 잡아 먹힘
                            isDead[j] = true;
                            continue;
                        } else {
                            //내가 잡아 먹음
                            isDead[map[sharks[j].row][sharks[j].col]] = true;
                        }
                    }
                    map[sharks[j].row][sharks[j].col] = j;
                }
            }
        }
        System.out.println(answer);
    }
}
