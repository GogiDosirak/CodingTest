import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Work {
    int time;
    int price;

    public Work(int time, int price) {
        this.time = time;
        this.price = price;
    }
}
public class Main {
    static int N, T, P;
    static int[] dp;
    static Work[] arr;
    public int dynamic(int N) {
        for (int i = 1; i <= N; i++) {
            if(i+arr[i].time <= N+1) { // 날짜가 범위를 넘어가지 않는 경우
                dp[i + arr[i].time] = Math.max(dp[i + arr[i].time], dp[i] + arr[i].price); // 현재값과 더해져서 만들어진 값 중에 더 최대값으로 갱신
                // 왜? 10일이 마지막이고 1일을 소요하는 경우, 11일째의 금액을 구해야하기 때문
            } // 안되는 경우엔 전날의 값을 넣어줌, 그러면 자연스레 퇴사일의 최대값도 들어간다.
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        return dp[N+1]; // 퇴사일(N+1)의 최대 수익을 반환
        
    }
 public static void main(String[] args) throws IOException {
        Main M = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Work[N+1];
     for (int i = 1; i <= N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         T = Integer.parseInt(st.nextToken());
         P = Integer.parseInt(st.nextToken());
         arr[i] = new Work(T,P);
     }
     dp = new int[N+2]; // 일수가 지날수록 얼마나 얻을 수 있는지 최대수입, 퇴사 다음날에 상담이 완료될 수 있으므로 N+2
     System.out.println(M.dynamic(N));
    }
}

