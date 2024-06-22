import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int except = (int) (Math.round((N*0.15)));
        int people = arr.length - except*2;

        for (int i = except; i < arr.length - except; i++) { 
            sum += arr[i];
        }

        System.out.println(Math.round((double)sum/people));

    }
}

