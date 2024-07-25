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
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> hash1 = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String p = sc.nextLine();
            hash1.put(i,p);
            hash2.put(p,i);
        }

        for (int i = 0; i < M; i++) {
            String a = sc.nextLine();
            if(49 <= a.charAt(0) && a.charAt(0) <= 57) {
                sb.append(hash1.get(Integer.parseInt(a))).append('\n');
            } else {
                sb.append(hash2.get(a)).append('\n');
            }

        }
        System.out.println(sb);


    }
}
