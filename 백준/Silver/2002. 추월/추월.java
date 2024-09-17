import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(),i);
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            String car = br.readLine();
            arr[i] = map.get(car);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(arr[i] > arr[j]) {
                    answer++;
                    break;
                }

            }

        }


        System.out.println(answer);


    }
}



