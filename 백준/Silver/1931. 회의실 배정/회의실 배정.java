import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting m) {
        if(this.end == m.end) {
            return this.start - m.start;
        }
        else {
            return this.end - m.end;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] arr = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        int answer = 0;
        int et = 0;
        for(Meeting m : arr) {
            if(m.start >= et) {
                et = m.end;
                answer++;
            }
            
            
        }
        System.out.println(answer);
        
       
        


    }
}
