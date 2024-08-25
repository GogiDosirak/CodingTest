import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N;
    static int[] dy;
    public int DP(int N) {
        if(dy[N] != 0) {
            return dy[N];
        }
        if(N == 1) {
            return dy[1] = 1;
        }
        else if(N == 2) {
            return dy[2] = 2;
        }
        else {
            return dy[N] = (DP(N-2) + DP(N-1)) % 10007;
        }
    }
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dy = new int[N+1];
        System.out.println( T.DP(N));
    }
}

