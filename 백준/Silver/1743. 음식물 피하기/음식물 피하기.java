import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,K,size,answer;
    static int[][] arr;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                size++;
                DFS(nx,ny);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;

        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(arr[i][j] == 1) {
                    size = 0;
                    T.DFS(i,j);
                    answer = Math.max(answer, size);
                }

            }
        }
        System.out.println(answer);





    }
}



