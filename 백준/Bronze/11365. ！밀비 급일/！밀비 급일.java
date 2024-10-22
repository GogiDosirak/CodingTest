import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main T = new Main();
        ArrayList<String> arr = new ArrayList<>();
        while(true) {
            String s = br.readLine();
            if(s.equals("END")) {
                break;
            }
            arr.add(s);
        }

        for(String x : arr) {
            StringBuffer sb = new StringBuffer(x);
            System.out.println(sb.reverse());
        }

    }
}