import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[] cdp,rdp,arr;
    public void CDP(int N) {
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i] && max < cdp[j]) {
                    max = Math.max(max, cdp[j]);
                }
            }
            cdp[i] = max + 1;
        }

    }
    public void RDP(int N) {
        for (int i = N-1; i >= 0; i--) {
            int max = 0;
            for (int j = i+1; j < N; j++) {
                if(arr[j] < arr[i] && max < rdp[j]) {
                    max = Math.max(max, rdp[j]);
                }
            }
            rdp[i] = max + 1;
        }



    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cdp = new int[N];
        rdp = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cdp[0] = 1; // 순방향 오름차순 수열
        rdp[N-1] = 1; // 역방향 내림차순 수열
        int answer = 0;
        T.CDP(N);
        T.RDP(N);
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, rdp[i] + cdp[i] -1); // 같은 위치에서 중복되므로 -1을 해줘야함

        }
        System.out.println(answer);


    }
}


