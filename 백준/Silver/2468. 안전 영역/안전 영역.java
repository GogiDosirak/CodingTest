import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr, ch;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS(int x, int y, int rain) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0 && arr[nx][ny] > rain) {
                ch[nx][ny] = 1;
                DFS(nx,ny,rain);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;
                max = Math.max(max, a);
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= max; i++) {
            ch = new int[N][N];
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(arr[j][k] > i && ch[j][k] == 0) {
                        cnt++;
                        ch[j][k] = 1;
                        T.DFS(j,k,i);
                    }
                }
            }
            answer = Math.max(answer, cnt);

        }
        System.out.println(answer);

    }


}

