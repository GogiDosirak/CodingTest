import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, t;
    static int[][] arr;
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    static int cnt;
    static ArrayList<Integer> answer;
    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 1) {
                cnt++;
                arr[nx][ny] = 0;
                DFS(nx,ny);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        answer = new ArrayList<>();
        cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                    T.DFS(i,j);
                    answer.add(cnt);
                    cnt = 1;
                }

            }

        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for(int x : answer) {
            System.out.println(x);
        }

    }
}

