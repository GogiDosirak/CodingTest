import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N;
    static int[] dy; // N보다 크지 않으므로 넉넉하게 잡기
    public void DP(int N) {
        dy[0] = 0;
        dy[1] = 0;
        for (int i = 2; i < N+1; i++) {
            dy[i] = dy[i-1] + 1; // dy[i]는 무조건 dy[i-1]에서 +1을 한 값임.
            if(i % 2 == 0) {  // 2로 나눠지는 경우
                dy[i] = Math.min(dy[i], dy[i/2]+1); // 1을 빼는게 더 최선일지, 2로 나누는게 더 최선일지 min으로 계산 (+1을 해주는 이유는 /2를 해주면 연산횟수가 +1이기 떄문)
            }
            
            if(i % 3 == 0) { // 3으로 나눠지는 경우
                dy[i] = Math.min(dy[i], dy[i/3]+1);
                
            }
            
        }



    }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new int[N+1];
        T.DP(N);
        System.out.println(dy[N]);



    }
}

