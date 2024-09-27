import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;



public class Main {
    static int N,M,K;
    static int[][] arr;
    static int[][] dp, ch;
    static int ax,ay,cnt;
    int[] dx = {0,1};
    int[] dy = {1,0};
    public void DFS(int x, int y) {
        if(K != 0) {
            if (ch[ax][ay] == 1 && x == N && y == M) {
                cnt++;
                return;
            }
        } else {
            if (x == N && y == M) {
                cnt++;
                return;
            }

        }
        for (int i = 0; i < 2; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>= 1 && nx <= N && ny>=1 && ny <= M && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                DFS(nx,ny);
                ch[nx][ny] = 0;
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
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < M; j++) {
                arr[i][j] = (i-1)*5 + j;
            }
        }
        dp = new int[N+1][M+1];
        ch = new int[N+1][M+1];
        ax = (K/5) +1;
        ay = K%5;
        T.DFS(1,1);
        System.out.println(cnt);



    }
}
