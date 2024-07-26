import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < N+M; i++) {
            arr.add(sc.nextLine());
        }
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i),0)+1);
        }
        int cnt = 0;
        ArrayList<String> answer = new ArrayList<>();
        for(String x : map.keySet()) {
            if(map.get(x) == 2) {
                cnt++;
                answer.add(x);
            }
        }
        Collections.sort(answer);
        System.out.println(cnt);
        for(String s : answer) {
            System.out.println(s);
        }


    }
}
