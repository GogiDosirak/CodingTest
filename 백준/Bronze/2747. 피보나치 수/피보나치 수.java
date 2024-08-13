import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int[] memo;
    public int fibo(int n) {
        if(memo[n] > 0) {
            return memo[n];
        }
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return memo[n] = fibo(n-2) + fibo(n-1);
    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        memo = new int[46];
        System.out.println(P.fibo(n));

    }
}

