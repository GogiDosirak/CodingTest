import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int answer = 0;
    static Queue<Integer> Q;
    static int[] ch;
    public void BFS(int v) {
        Q.offer(v);
        while(!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int a = Q.poll();
                if(a == K) {
                    System.out.println(answer);
                    return;
                }
                int[] next = {a + 1, a - 1, a * 2};
                for(int nx : next) {
                    if(nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            answer++;
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = new LinkedList<>();
        ch = new int[100001];
        ch[N] = 1;
        T.BFS(N);
    }
}

