import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sc = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[sc.countTokens()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sc.nextToken());
        }
        Arrays.sort(arr);
        for(int x : arr) {
            System.out.print(x + " ");
        }


    }
}
