import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0 && pQ.isEmpty()) {
                sb.append(0).append('\n');
                continue;
            }
            if(a == 0) {
                int b = pQ.poll();
                sb.append(b).append('\n');
                continue;
            }
            pQ.offer(a);
        }

        System.out.println(sb);


    }
}

