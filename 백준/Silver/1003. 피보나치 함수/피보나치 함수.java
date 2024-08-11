import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int[][] dy;
    public int[] fibo(int n) {
        dy[0][0] = 1;
        dy[0][1] = 0;
        dy[1][0] = 0;
        dy[1][1] = 1;
        if(dy[n][0] > 0 && dy[n][1] > 0) {
            return dy[n];
        }

        if(n >= 2) {
            dy[n][0] = fibo(n - 2)[0] + fibo(n - 1)[0];
            dy[n][1] = fibo(n - 2)[1] + fibo(n - 1)[1];
        }
        return dy[n];

    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dy = new int[41][2];
        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            P.fibo(a);
            System.out.println(dy[a][0] + " " + dy[a][1]);

        }
    }
}

