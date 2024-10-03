import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, ch;
    static ArrayList<Integer> answer;
    public void DFS(int start, int target) {
      if(ch[arr[start]] == 0) {
          ch[arr[start]] = 1;
          DFS(arr[start], target);
          ch[arr[start]] = 0;
      }
      if(arr[start] == target) {
          answer.add(target);
      }



    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        ch = new int[N+1]; // 체크되어 있다면, 사이클이 발생한다면 넣어도 무방 -> 사이클이 발생하는 애를 다 넣으면 최대값이 됨
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            ch[i] = 1;
            T.DFS(i,i);
            ch[i] = 0;
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int a : answer) {
            System.out.println(a);
        }






    }
}