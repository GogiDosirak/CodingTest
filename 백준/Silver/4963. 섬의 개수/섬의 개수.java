import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w,h;
    static int[][] arr;
    int[] dx = {1,1,0,-1,-1,-1,0,1};
    int[] dy = {0,1,1,1,0,-1,-1,-1};
    public void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                DFS(nx,ny);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(arr[i][j] == 1) {
                        cnt++;
                        arr[i][j] = 0;
                        T.DFS(i,j);
                    }

                }

            }
            System.out.println(cnt);


        }


    }


}

