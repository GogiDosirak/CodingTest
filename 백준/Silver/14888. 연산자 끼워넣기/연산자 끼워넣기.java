import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    static int N, max, min, index;
    static int[] arr, cal;
    public void DFS(int L, int v) {
        if(L == N) {
            max = Math.max(max, v);
            min = Math.min(min, v);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                if(cal[i] != 0) {
                    cal[i]--;
                    if(i == 0) {
                        DFS(L+1,v + arr[L]);
                    } else if(i == 1) {
                        DFS(L+1, v - arr[L]);
                    } else if(i == 2) {
                        DFS(L+1, v * arr[L]);
                    } else if(i == 3) {
                        DFS(L+1, v / arr[L]);
                    }
                    cal[i]++; // 재귀가 종료되면 다시 ++해줘야 다른 재귀에서도 사용 가능
                }

            }

        }

    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        index = 0;
        T.DFS(1,arr[0]);
        System.out.println(max);
        System.out.println(min);







    }
}

