import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String answer="";
        String[] arr = new String[2];
        arr[0] = new StringBuilder(st.nextToken()).reverse().toString();
        arr[1] = new StringBuilder(st.nextToken()).reverse().toString();

        if(Integer.parseInt(arr[0]) > Integer.parseInt(arr[1])) {
            answer = arr[0];
        } else {
            answer = arr[1];
        }

        System.out.println(answer);

    }


}