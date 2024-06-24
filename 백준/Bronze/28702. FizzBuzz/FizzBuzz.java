import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        int num = 0;
        int answer = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = br.readLine();
            char c = arr[i].charAt(0);
            if(Character.isDigit(c)) {
                num = i;
            }
        }

        if(num == 0) {
            answer = Integer.parseInt(arr[0]) + 3;
        } else if(num == 1) {
            answer = Integer.parseInt(arr[1]) + 2;
        } else if(num == 2) {
            answer = Integer.parseInt(arr[2]) + 1;
        }

        if(answer%15 == 0) {
            System.out.println("FizzBuzz");
        } else if(answer%3 == 0 && answer % 5 != 0) {
            System.out.println("Fizz");
        } else if(answer%3 != 0 && answer % 5 == 0) {
            System.out.println("Buzz");
        } else if(answer%3 != 0 && answer % 5 != 0) {
            System.out.println(answer);
        }






    }
}






