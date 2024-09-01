import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static long[][] dp;
    static long mod = 1000000000;
    public long dynamic(int n) {
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j+1] % mod;
                } else if(j == 9) {
                    dp[i][j] = dp[i-1][j-1] % mod;
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }

            }
        }
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += dp[n][i];
        }
        return answer % mod;

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10]; // 자릿수와 숫자
        System.out.println(T.dynamic(n));






    }
}

