import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        int max = 0;
        int sum = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N-2; i++) {
            for (int j = i+1; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if (sum > max && sum <= K) {
                        max = sum;
                    }

                }
            }

        }
        System.out.println(max);


    }
}