import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] pm;
    public void solve(int v) {
        if(v == M) {
            for(int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();

        } else {
            if(v > 0) {
                for (int i = pm[v-1]; i <= N; i++) {
                    pm[v] = i;
                    solve(v+1);
                }
            } else {
                for (int i = 1; i <= N; i++) {
                    pm[v] = i;
                    solve(v + 1);
                }
            }


        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];
        T.solve(0);


    }
}

