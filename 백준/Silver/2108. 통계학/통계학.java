import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int[] count = new int[8001];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arr.add(a);
            count[a+4000]++;
        }
        int max = Arrays.stream(count).max().getAsInt();
        
        Collections.sort(arr);
        int avg;
        int mid;
        int frequent = 0;
        int range;
        double sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            if(count[arr.get(i)+4000] == max) {
                frequent = arr.get(i);
                cnt++;
                if(cnt == 2*max) {
                    break;
                }
            }
            
        }
        avg = (int) Math.round(sum/arr.size());
        mid = arr.get(arr.size()/2);
        range = Collections.max(arr) - Collections.min(arr);
        

        System.out.println(avg);
        System.out.println(mid);
        System.out.println(frequent);
        System.out.println(range);

    }
}

