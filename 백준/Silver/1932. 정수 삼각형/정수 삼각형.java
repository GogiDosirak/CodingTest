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
            for (int j = 0; j <= i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if ( j== i) {
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j-1], dp[i - 1][j]) + arr[i][j];
                }
            }

        }



    }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
     for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j <= i; j++) { // 하나씩 많아지므로
             arr[i][j] = Integer.parseInt(st.nextToken());
         }
     }
        dp[0][0] = arr[0][0];
     T.dynamic(N);
     int max = -99999;
     for (int i = 0; i < N; i++) {
         max = Math.max(max, dp[N-1][i]);
     }
     System.out.println(max);




    }
}

