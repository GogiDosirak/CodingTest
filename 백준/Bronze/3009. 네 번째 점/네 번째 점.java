import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Main P = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map1.put(a,map1.getOrDefault(a,0)+1);
            map2.put(b,map2.getOrDefault(b,0)+1);
        }
        int x = 0;
        int y = 0;
        for(int m : map1.keySet()) {
            if(map1.get(m) == 1) {
                x = m;
            }
        }

        for(int m : map2.keySet()) {
            if(map2.get(m) == 1) {
                y = m;
            }
        }

        System.out.println(x + " " + y);





    }
}