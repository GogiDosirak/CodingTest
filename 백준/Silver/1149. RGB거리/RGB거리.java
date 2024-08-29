import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    public void dynamic(int N) {
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0]; // 해당 dp가 0번(red)일 때 최소값
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + arr[i][1]; // 해당 dp가 1번{green)일 때 최소값
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + arr[i][2]; // 해당 dp가 2번(blue)일 때 최소값
        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1],dp[N-1][2])));

    }
 public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];
     for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < 3; j++) {
             arr[i][j] = Integer.parseInt(st.nextToken());
         }
     }
     dp[0][0] = arr[0][0];
     dp[0][1] = arr[0][1];
     dp[0][2] = arr[0][2];
     M.dynamic(N);



    }
}

