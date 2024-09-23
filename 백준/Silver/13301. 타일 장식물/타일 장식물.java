import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static long[] dx;
    public void dynamic(int N) {
        for (int i = 3; i <= N; i++) {
            dx[i] = dx[i-2] + dx[i-1];
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dx = new long[N+1];
        dx[1] = 4;
        if(N > 1) {
            dx[2] = 6;
        }
        T.dynamic(N);
        System.out.println(dx[N]);




    }
}



