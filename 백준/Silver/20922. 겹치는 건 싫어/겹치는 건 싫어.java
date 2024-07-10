import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        int lt = 0;
        int answer = 0;
        for(int rt = 0; rt < N; rt++) {
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            while(map.get(arr[rt]) > K) {
                map.put(arr[lt],map.get(arr[lt])-1);
                if(map.get(arr[lt]) == 0) {
                    map.remove(arr[lt]);
                }
                lt++;

            }
           answer = Math.max(answer, rt-lt+1);

        }
        System.out.println(answer);



    }
}