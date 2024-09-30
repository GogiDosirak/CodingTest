import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp, arr;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dp[i] = i; // 최대값으로 초기화
            
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) { // 해당 항까지 제곱수가 있다면, 거기서 그 값 중 최소에서 +1
                if(dp[i] > dp[i - (j * j) ]+ 1) { // 최소값 갱신
                    dp[i] = dp[i-(j*j)] + 1;
            }
        }
        }

        System.out.println(dp[N]);





    }
}