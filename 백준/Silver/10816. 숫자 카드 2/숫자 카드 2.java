import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[20000001]; //-10000000~10000000

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N ; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(cnt[Integer.parseInt(st2.nextToken())+10000000]).append(" ");

        }
        System.out.println(sb);




        }



        }

