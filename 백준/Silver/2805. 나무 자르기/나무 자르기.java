import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public long binary(int N, long M, int[] arr) {
        Main T = new Main();
        long answer = 0;
        long lt = 1;
        long rt = Arrays.stream(arr).max().getAsInt();
        while(lt <= rt) {
            long mid = (lt+rt)/2;
            if(T.solve(mid,arr) < M) {
                rt = mid-1;
            } else if(T.solve(mid,arr) >= M) {
                lt = mid+1;
                answer = mid;
            }

        }
        return answer;

    }

    public long solve(long mid, int[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] - mid > 0) {
                sum += arr[i] - mid;
            }
        }

        return sum;
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println(T.binary(N,M,arr));

    }
}