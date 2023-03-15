package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
교수님 해설 강의
구현 - 시뮬레이션
1. 구슬 떨어뜨리기 : 중복순열 (재귀)
2. 구슬이 떨어지는 첫 벽돌 찾기
3. 첫 벽돌 기준 사방 (cnt-1) 연쇄적으로 펑
4. 벽돌 내리기 
구슬을 던지는 횟수만큼 1-4 반복

시뮬레이션은 디버깅이 어렵기 때문에 출력용 메서드를 만드는 것이 좋다.

*주의할 점
배열 복사 (배열을 복사해서 써야한다.)
*가지치기
모든 벽돌이 다 깨졌을 때
-> 구슬을 던질떄마다 남는 벽돌 카운팅해서 0개면 테스트케이스 종료
 */
public class SWEA5656 {
    private static int N, H, W, min;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    private static Stack<Integer> stack = new Stack<>();

    private static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    //자식 비교

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];
            for (int r = 0; r < H; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            go(0, map);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
    /**
     * 구슬 한 번 던지기
     * @param count 구슬이 던져진 횟수
     * @param map 벽돌 맵
     */
    private static boolean go(int count, int[][] map) {
        //벽돌 개수 파악
        int result = getRemain(map);
        if (result == 0) {
            min = 0;
            return true;
        }
        if (count == N) {
            if (min > result)
                min = result;
            return false;
        }
        int[][] newMap = new int[H][W];
        // 모든 열에 구슬 던져보기
        // c == 구슬을 던지는 열
        for (int c = 0; c < W; c++) {
            // 구슬에 처음 맞는 벽돌 찾기 (위쪽에서)
            int r = 0;
            while (r < H && map[r][c] == 0)
                ++r;
            if (r == H) {
                // c열에 맞는 벽돌이 없으면 다음 열로
                continue;
            }
            copy(map, newMap);
            // 벽돌 깨기
            boom(newMap, r, c);
            // 벽돌 내리기
            down(newMap);
            // 다음 구슬 던지러 가기
            if (go(count + 1, newMap))
                return true;
        }
        return false;
    }

    private static int getRemain(int[][] map) {
        int count = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] > 0)
                    count++;
            }
        }
        return count;
    }

    // BFS
    // 시작 좌표 (r,c)
    private static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();
        if (map[r][c] > 1) {
            queue.offer(new Point(r, c, map[r][c]));
        }
        map[r][c] = 0; // 방문체크 : 빈공간으로 만듦
        Point current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            // 현 벽돌의 cnt-1만큼 4방 체크.
            // 중간에 빈칸 만나도 멈추지 X
            for (int d = 0; d < 4; d++) {
                int nr = current.r;
                int nc = current.c;
                for (int k = 1; k <= current.cnt - 1; k++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (nc >= 0 && nr >= 0 && nc < W && nr < H && map[nr][nc] > 0) {
                        if (map[nr][nc] > 1) {
                            queue.offer(new Point(nr, nc, map[nr][nc]));
                        }
                        map[nr][nc] = 0; // 방문체크 : 빈공간으로 만든다.
                    }
                }
            }
        }
    }

    private static void down(int [][] map) {
        // 위쪽부터 벽돌만 스택에 집어넣고, 아래쪽부터 채운다.
        // 비어있는 상태를 유지하기 때문에 스태틱 변수로 사용
        for (int c = 0; c < W; c++) {
            for (int r = 0; r < H; r++) {
                if (map[r][c] > 0) {
                    stack.push(map[r][c]);
                    map[r][c] = 0;
                }
            }
            int r = H-1;
            while(!stack.isEmpty()){
                map[r--][c] = stack.pop();
            }
        }
    }

    private static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }

}
