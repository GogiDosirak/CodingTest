import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Main {
    static int[] dy;
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dy = new int[N];
        dy[0] = 1;
        int answer = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(dy[i], answer);
            
            
        }
        System.out.println(answer);
        

    }
}

