import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.toUpperCase().equals("N")) {
            System.out.println("Naver D2");
        } else {
            System.out.println("Naver Whale");
        }

    }
}