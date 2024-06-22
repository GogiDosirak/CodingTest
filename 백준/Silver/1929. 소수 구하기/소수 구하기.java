import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N + 1]; // 만약 500까지면 0부터 500까지이므로 크기는 501. +1해줘야함
        // boolean의 기본값은 false, 즉 false인게 소수이고 true면 소수x
        getPrime(N, prime);

        for (int i = M; i <= N; i++) {
            if(!prime[i]) {
                sb.append(i).append('\n');
            }
            
        }
        System.out.println(sb);

    }

    public static void getPrime(int N, boolean[] prime) {
        prime[0] = prime[1] = true; // 0과 1은 소수가 아니므로 true;
        // N+1이나 prime.length 해주는 이유 -> 500까지라면  arr[501]까지 해야됨
        for (int i = 2; i <= Math.sqrt(prime.length); i++) { 
            if(prime[i]) {
                continue; // prime[i]가 true이면 소수가 아니므로 그냥 지나면됨!
            } // 소수인 경우, 
            for (int j = i * i; j <= N; j+=i) {
                // i * i 부터 시작하는 이유는 i가 5라면 i * 2, i * 3 같이 i보다 작은 경우는 앞에서 처리되기 때문
                // 해당 배수를 소수 목록에서 지워야하므로
                prime[j] = true;
            }
        }


    }
}






