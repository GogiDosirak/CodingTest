import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 배열은 반드시 정렬돼있어야함

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr, Integer.parseInt(st.nextToken()))).append(" ");

        }
        System.out.println(sb);

        }

    public static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi) {
            int mid = (lo+hi)/2;
            if(key < arr[mid]) {
                hi = mid-1;
            }
            else if(key > arr[mid]) {
                lo = mid+1;
            }
            else {
                return 1; // 있으면 1
            }

        }
        return 0; // 없으면 0

    }

        }




