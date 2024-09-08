import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x;
    int y;
    int z;

    public Point(int z, int x, int y) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
public class Main {
    static int M, N, H, level;
    static int[][][] arr;
    static Queue<Point> Q;
    static int[] dx;
    static int[] dy;
    static int[] dz;
    public void BFS() {
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                Point p = Q.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    int nz = p.z + dz[j];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H && arr[nz][nx][ny]== 0) {
                        arr[nz][nx][ny] = 1;
                        Q.offer(new Point(nz,nx,ny));
                    }
                }
            }
            level++;
        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][N][M];
        Q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) {
                        Q.offer(new Point(i,j,k));
                    }
                }
            }
        }

        dx = new int[] {1,0,-1,0,0,0};
        dy = new int[] {0,1,0,-1,0,0};
        dz = new int[] {0,0,0,0,1,-1};
        T.BFS();
        boolean flag = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(arr[i][j][k] == 0) {
                        flag = false;
                    }
                }
            }
        }

        if(flag) {
            System.out.println(level -1);
        } else {
            System.out.println(-1);
        }







    }
}



