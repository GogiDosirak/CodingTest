import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static long A,B;
    int L;
    public void BFS(Long A) {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(A);
        while(!Q.isEmpty()) {
            int len = Q.size();
            L++;
            for (int i = 0; i < len; i++) {
                long a = Q.poll();
                if(a == B) {
                    System.out.println(L);
                    return;
                }
                if(a * 2 <= B) {
                    Q.offer(a * 2);
                }
                if(a * 10 + 1 <= B) {
                    Q.offer(a * 10 + 1);
                }
                }
            }
        System.out.println(-1); // 도달할 수 없는 경우.

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        T.BFS(A);
    }
}

