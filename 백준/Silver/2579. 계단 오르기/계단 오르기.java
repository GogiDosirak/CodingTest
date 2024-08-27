import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N;
    static int[] arr;
    static Integer[] dp;
    public int dynamic(int N) {
        if(dp[N] != null) {
            return dp[N];
        }
        dp[N] = Math.max(dynamic(N-2), dynamic(N-3) + arr[N-1]) + arr[N]; // 시도 가능한 경우의 수 중 가장 최선을 선택 // 재귀를 통한 탑다운 방식
        return dp[N];
    }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new Integer[N+1];
     for (int i = 1; i <= N; i++) {
         int a = Integer.parseInt(br.readLine());
         arr[i] = a;
     }
     dp[0] = arr[0]; // Integer는 기본값이 null이므로 초기화
     dp[1] = arr[1]; // 1번까지 가는법은 하나밖에 없으므로 무조건 arr[1]
     if(N >= 2) {
         dp[2] = arr[1] + arr[2]; // 방법이 두개가 있지만, 무조건 arr[1]을 거쳐서 오는게 최선
     }

     System.out.println(T.dynamic(N));


    }
}

