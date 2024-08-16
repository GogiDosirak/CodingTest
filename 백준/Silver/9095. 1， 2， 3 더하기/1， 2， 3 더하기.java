import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dy;
    public int solve(int a) {
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;
        for (int i = 4; i < 11; i++) {
            dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
        }

        return dy[a];

    }
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dy = new int[11];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int a = Integer.parseInt(br.readLine());
            System.out.println(P.solve(a));

        }



    }
}

