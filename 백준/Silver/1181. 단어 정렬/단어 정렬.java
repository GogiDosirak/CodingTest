import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            array.add(br.readLine());
        }

        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 단어 길이가 같을 경우, 사전순 정렬
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });
        
        // 맨 처음 단어
        sb.append(array.get(0)).append('\n');

        // 중복되지 않는 단어만 출력
        // 정렬했으므로 같은 단어는 같이 모여있음
        for (int i = 1; i < N; i++) {
            if(!array.get(i).equals(array.get(i-1))) {
                sb.append(array.get(i)).append('\n');
            }

        }

        System.out.println(sb);
    }
}