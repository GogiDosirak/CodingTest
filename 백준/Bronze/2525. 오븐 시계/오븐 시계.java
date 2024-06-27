import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        // m + c가 60을 못넘는 경우 -> 그냥 분만 더해주면됨
        if((m + c) < 60) {
            System.out.println(h + " " + (m+c));
        } else { // m + c가 60을 넘는 경우, 60으로 나눠서 시간만큼 더해줌 -> 시간이 24가 넘으면 24를 뺴줌
            if(h + ((m+c)/60) >= 24) {
                System.out.println((h+((m+c)/60)-24) + " " + (m+c)%60);
            } else {
                System.out.println((h+(m+c)/60) + " " + (m+c)%60);
            }
        }


    }
}