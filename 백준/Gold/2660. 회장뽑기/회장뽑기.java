import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][N+1];
        int INF = 999999999;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = INF;
                if(i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1) {
                break;
            }
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        int score = INF;
        int cnt = 0;
        int[] answer = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int a = Arrays.stream(arr[i]).max().getAsInt();
            answer[i] = a;
        }
        for(int x : answer) {
            if(x != 0) {
                score = Math.min(x, score);
            }
        }

        for (int i = 1; i <= N; i++) {
            if(answer[i] == score) {
                cnt++;
            }
        }
        System.out.println(score + " " + cnt);
        for (int i = 1; i <= N; i++) {
            if(answer[i] == score) {
                System.out.print(i + " ");
            }
        }









    }
}

