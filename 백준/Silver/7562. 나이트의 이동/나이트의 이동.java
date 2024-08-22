import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Chess {
    int x;
    int y;
    public Chess(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n,l, sx, sy, ax, ay, answer;
    int[] dx = {2,1,-1,-2,-2,-1,1,2};
    int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int[][] ch;
    public void BFS(int x, int y) {
        Queue<Chess> Q = new LinkedList<>();
        Q.offer(new Chess(x,y));
        if(x == ax && y == ay) {
            System.out.println(0);
            return;
        }
        while(!Q.isEmpty()) {
            int len = Q.size();
            answer++;
            for (int i = 0; i < len; i++) {
                Chess a = Q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = a.x + dx[j];
                    int ny = a.y + dy[j];
                    if(nx >= 0 && nx < l && ny >= 0 && ny < l &&ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        Q.offer(new Chess(nx, ny));
                        if (nx == ax && ny == ay) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            answer = 0;
            l = Integer.parseInt(br.readLine());
            ch = new int[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken()); // 출발위치 x
            sy = Integer.parseInt(st.nextToken()); // 출발위치 y
            ch[sx][sy] = 1;
            st = new StringTokenizer(br.readLine());
            ax = Integer.parseInt(st.nextToken()); // 도착위치 x
            ay = Integer.parseInt(st.nextToken()); // 도착위치 y
            T.BFS(sx,sy);
        }

    }
}

