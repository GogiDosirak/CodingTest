import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N, M = 0;
    static int[] arr;
    static int[] ch;
    int tmp = 0;
    public void DFS(int L) {
        if(L == M) {
            for(int x : arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                if(ch[i] == 0 && i > tmp) {
                    ch[i] = 1;
                    arr[L] = i;
                    tmp = i;
                    DFS(L+1);
                    ch[i] = 0;
                    tmp = 0;
                }

            }


        }


    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        ch = new int[N+1];
        T.DFS(0);




    }
}
