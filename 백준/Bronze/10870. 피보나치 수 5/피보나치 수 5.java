import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int recursive(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return recursive(N-1) + recursive(N-2);


    }

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
        System.out.println(recursive(n));

    }
}
