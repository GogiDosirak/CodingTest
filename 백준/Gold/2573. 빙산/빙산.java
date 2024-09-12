import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, year, ice;
    static int[][] arr,ch,tempArr;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] > 0 && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                DFS(nx,ny);
            }

        }
    }
    public void down(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
                tempArr[x][y]--;
                if(tempArr[x][y] < 0) {
                    tempArr[x][y] = 0;
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
        arr = new int[N][M];
        tempArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                tempArr[i][j] = arr[i][j];
            }
        }


        while(true) {
            ch = new int[N][M]; // 시작할떄마다 ch 배열 초기화
            ice = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] > 0 && ch[i][j] == 0) {
                        ice++;
                        ch[i][j] = 1;
                        T.DFS(i, j);
                        if (ice >= 2) {
                            System.out.println(year);
                            return;
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] > 0) {
                        T.down(i,j);
                    }
                }
            }
            if(ice == 0) {
                System.out.println(0);
                return;
            }
            year++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = tempArr[i][j];
                }
            }
        }
    }
}



