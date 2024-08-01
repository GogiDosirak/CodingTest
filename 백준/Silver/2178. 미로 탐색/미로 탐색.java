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
    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(1,1));
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 1 && nx <= N && ny >=1 && ny <= M && arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
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
        arr = new int[N+1][M+1];
        dis = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = line.charAt(j-1) - '0'; // '0'을 빼주면 숫자로 변환됨
            }
        }
        arr[1][1] = 0;
        dis[1][1] = 0;
        T.BFS(1,1);
        System.out.println(dis[N][M]+1);



    }
}
