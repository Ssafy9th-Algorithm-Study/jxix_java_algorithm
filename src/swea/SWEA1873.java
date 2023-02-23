package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            String input;
            char[][] map = new char[H][W];
            int x = 0;
            int y = 0;
            for (int i = 0; i < H; i++) {
                input = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j]=='^' || map[i][j]=='v'  || map[i][j]=='<' || map[i][j]=='>'){
                        x = i;
                        y = j;
                    }
                }
            }
            int N = Integer.parseInt(br.readLine());
            int nx, ny;
            input = br.readLine();
            for (int i = 0; i < N; i++) {
                if (input.charAt(i) == 'U'){
                    nx = x-1;
                    ny = y;
                    map[x][y] = '^';
                    if (nx >= 0 && ny >=0 && nx<H && ny <W && map[nx][ny]=='.'){
                        map[x][y] = '.';
                        x = nx;
                        y = ny;
                        map[x][y] = '^';
                    }
                } else if (input.charAt(i) == 'D'){
                    nx = x+1;
                    ny = y;
                    map[x][y] = 'v';
                    if (nx >= 0 && ny >=0 && nx<H && ny <W && map[nx][ny]=='.'){
                        map[x][y] = '.';
                        x = nx;
                        y = ny;
                        map[x][y] = 'v';
                    }
                } else if (input.charAt(i) == 'L'){
                    nx = x;
                    ny = y-1;
                    map[x][y] = '<';
                    if (nx >= 0 && ny >=0 && nx<H && ny <W && map[nx][ny]=='.'){
                        map[x][y] = '.';
                        x = nx;
                        y = ny;
                        map[x][y] = '<';
                    }
                } else if (input.charAt(i) == 'R'){
                    nx = x;
                    ny = y+1;
                    map[x][y] = '>';
                    if (nx >= 0 && ny >=0 && nx<H && ny <W && map[nx][ny]=='.'){
                        map[x][y] = '.';
                        x = nx;
                        y = ny;
                        map[x][y] = '>';
                    }
                } else if (input.charAt(i) == 'S'){
                    if (map[x][y]=='^'){
                        for (int j = x-1; j >=0; j--) {
                            if (map[j][y] == '*'){
                                map[j][y] = '.';
                                break;
                            }
                            if (map[j][y] == '#'){
                                break;
                            }
                        }
                    } else if (map[x][y]=='v') {
                        for (int j = x+1; j <H; j++) {
                            if (map[j][y] == '*'){
                                map[j][y] = '.';
                                break;
                            }
                            if (map[j][y] == '#'){
                                break;
                            }
                        }
                    } else if (map[x][y]=='<') {
                        for (int j = y-1; j >=0; j--) {
                            if (map[x][j] == '#'){
                                break;
                            }
                            if (map[x][j] == '*'){
                                map[x][j] = '.';
                                break;
                            }
                        }
                    } else if (map[x][y]=='>'){
                        for (int j = y+1; j <W; j++) {
                            if (map[x][j] == '*'){
                                map[x][j] = '.';
                                break;
                            }
                            if (map[x][j] == '#'){
                                break;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(t).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }
}
