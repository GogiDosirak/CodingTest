import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubble(arr,arr.length);

        for(int a : arr) {
            sb.append(a).append('\n');
        }
        System.out.println(sb);

    }

    public static void bubble(int[] arr, int size) {
        // 라운드는 배열크기 -1까지.., 1라운드부터 시작
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size-i; j++) { //라운드가 늘수록 비교횟수는 1씩 줄어들음 => size-i
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } // 자리를 서로 바꿔줌

            }

        }

    }
}















