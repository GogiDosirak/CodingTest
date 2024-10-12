import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            Q.add(i);
        }
        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while(true) {
            if(cnt == N) {
                break;
            }
            for (int i = 0; i < K-1; i++) {
                int a = Q.poll();
                Q.add(a);
            }
            int b = Q.poll();
            answer.add(b);
            cnt++;

        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 0; i < N; i++) {
            sb.append(answer.get(i));
            if(i != N-1) {
                sb.append(",").append(" ");
            }

        }
        sb.append(">");
        System.out.println(sb);

    }
}