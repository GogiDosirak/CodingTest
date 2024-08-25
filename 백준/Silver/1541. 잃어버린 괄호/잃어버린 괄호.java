import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
 public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        String[] minus = s.split("-");

     for (int i = 0; i < minus.length; i++) {
         int temp = 0;

         String[] plus =  minus[i].split("\\+");

         for (int j = 0; j < plus.length; j++) {
             temp += Integer.parseInt(plus[j]);
         }

         if(minus.length == 1 || i == 0) {
             sum = temp;
         }
         else {
             sum -= temp;
         }
     }
     System.out.println(sum);


    }
}

