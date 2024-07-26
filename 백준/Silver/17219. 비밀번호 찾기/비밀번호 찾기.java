import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> hash = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String site = sc.next();
            String pass = sc.next();
            hash.put(site,pass);
        }
        for (int i = 0; i < M; i++) {
            String answer = sc.next();
            sb.append(hash.get(answer)).append('\n');

        }
        System.out.println(sb);



    }
}
