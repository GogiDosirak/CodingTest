import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    public void solution(int K) {
        for(int nv : graph.get(K)) {
            if(ch[nv] == 0) {
                ch[nv] = 1;
                solution(nv);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a); //양방향이므로
        }
        ch = new int[N+1];
        ch[1] = 1;
        int answer = 0;
        T.solution(1);
        for (int i = 2; i < N+1; i++) {
            if(ch[i] == 1) {
                answer++;
            }

        }
        System.out.println(answer); // ch가 1이라면 이미 방문한것


        }
    }

