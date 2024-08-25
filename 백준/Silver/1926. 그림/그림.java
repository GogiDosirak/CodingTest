import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
         static int n,m,cnt,width;
         static int answer = 0;
         static int[][] arr;
         int[] dx = {1,0,-1,0};
         int[] dy = {0,1,0,-1};
        public void BFS(int x, int y) {
            Queue<Point> Q = new LinkedList<>();
            Q.offer(new Point(x,y));
            while(!Q.isEmpty()) {
                int len = Q.size();
                for (int i = 0; i < len; i++) {
                    Point a = Q.poll();
                    for (int j = 0; j < 4; j++) {
                        int nx = a.x + dx[j];
                        int ny = a.y + dy[j];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 1) {
                            arr[nx][ny] = 0;
                            Q.offer(new Point(nx, ny));
                            width++;
                        }
                    }
                }
            }
            answer = Math.max(answer, width);
        }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
     for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < m; j++) {
             arr[i][j] = Integer.parseInt(st.nextToken());
         }
     }
     cnt = 0;
     for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
             if(arr[i][j] == 1) {
                 width = 1;
                 arr[i][j] = 0;
                 cnt++;
                 T.BFS(i,j);
             }
         }
     }

     System.out.println(cnt);
     System.out.println(answer);





    }
}

