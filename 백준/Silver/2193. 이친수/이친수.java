import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static long[] dp;
    public long dynamic(int n) {
        if(dp[n] != 0) {
            return dp[n];
        }
        if(n == 0) {
            return dp[0] = 0;
        }
        if(n == 1) {
            return dp[1] = 1;
        }
        return dp[n] = dynamic(n-1) + dynamic(n-2);
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1];
        System.out.println(T.dynamic(n));




    }
}

