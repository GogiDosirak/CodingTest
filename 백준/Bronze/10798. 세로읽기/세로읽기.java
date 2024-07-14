import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] arr = new String[5][15];
        for (int i = 0; i < 5; i++) {
            String[] c = br.readLine().split("");
            for (int j = 0; j < c.length; j++) {
                arr[i][j] = c[j];
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(arr[j][i] == null) {
                    continue;
                }
                sb.append(arr[j][i]);
            }

        }
        System.out.println(sb);

    }
}