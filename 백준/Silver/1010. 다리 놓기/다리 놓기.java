import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int T, N, M;
    static int[][] dp;
    public int dynamic(int N, int M) {
        if(dp[N][M] > 0) {
            return dp[N][M];
        }

        if(N == M || M == 0) { // nCn = 1, nC0 = 1
            return dp[N][M] = 1;
        }

        return dp[N][M] = dynamic(N-1,M-1) + dynamic(N-1,M);


    }
 public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
     for (int i = 0; i < T; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         M = Integer.parseInt(st.nextToken());
         N = Integer.parseInt(st.nextToken());
         dp = new int[35][35];
         System.out.println(P.dynamic(N,M));

     }

    }
}

