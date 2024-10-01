import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, lt, rt, mid, sum, answer;
    static int[] arr;
    public int binary() {
        Arrays.sort(arr);
        lt = 0;
        rt = Arrays.stream(arr).max().getAsInt();
        while(lt <= rt) {
            sum = 0;
            mid = (lt + rt) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if(sum > M) {
                rt = mid-1;
            } else if(sum <= M) {
                lt = mid+1;
                answer = mid;
            }
        }
        return answer;



    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        System.out.println(T.binary());








    }
}