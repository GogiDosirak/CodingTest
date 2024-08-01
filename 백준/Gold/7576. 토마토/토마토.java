import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N, M;
    static int[][] arr, dis;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    static Queue<Point> Q = new LinkedList<>();
    public void BFS() {
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    Q.offer(new Point(nx,ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }

            }

        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    Q.offer(new Point(i,j));
                }
            }
        }
        dis = new int[M][N];
        T.BFS();
        boolean flag = true;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    flag = false;
                }

            }
        }
        int answer = Integer.MIN_VALUE;
        if(flag) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    answer = Math.max(answer, dis[i][j]);

                }
            }
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }


    }
}
