import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static long[] dp;
    public long dynamic(int N) {
        if(dp[N] != 0) {
            return dp[N];
        }
           if(N == 1) {
               return dp[N] = 1;
           }
           if(N == 2) {
               return dp[N] = 2;
           }
           return dp[N] = (dynamic(N-2) + dynamic(N-1)) % 15746;
    }

    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        System.out.println(P.dynamic(N));

        }







    }


