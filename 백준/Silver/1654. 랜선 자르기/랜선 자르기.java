import java.util.*;

public class Main {
    public long binary(int K, long[] arr) {
        Main T = new Main();
        long lt = 1;
        long rt = Arrays.stream(arr).max().getAsLong();
        long answer = 0;
        while(lt <= rt) {
            long mid = (lt+rt)/2;
            if(K > T.solve(mid, arr)) {
                rt = mid-1;

            } else if(K <= T.solve(mid, arr)) {
                lt = mid+1;
                answer = mid;

            }

        }
        return answer;

    }

    public long solve(long mid, long[] arr) {
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]/mid;
        }
        return sum;
    }





public static void main(String[] args){
    Main T = new Main();
    Scanner sc=new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    long[] arr = new long[N];
    for (int i = 0; i < N; i++) {
        arr[i] = sc.nextInt();

    }

    System.out.println(T.binary(K,arr));


}
}