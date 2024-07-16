import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = N;
        for (int i = 0; i < N; i++) {
            for (int j = cnt; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
            cnt--;

        }

    }
}