import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid, copy, time;
    static int n,m;
    static int answer = Integer.MAX_VALUE;
    static List<Node> virus = new ArrayList<>();
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // n * n 크기
        n = Integer.parseInt(st.nextToken());
        // 활성 바이러스의 개수
        m = Integer.parseInt(st.nextToken());
        
        grid = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 2) virus.add(new Node(i,j));
            }
        }
        
        Main T = new Main();
        T.activate(0,0);
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }
    
    // 바이러스를 활성시키는 경우의 수 - 조합이므로 중복 제거 (시작 바이러스 이후만 탐색하게끔)
    public void activate(int count, int start) {
        if(count == m) {
            BFS();
            return;
        }
        
        for(int i = start; i < virus.size(); i++) {
            Node node = virus.get(i);
            grid[node.x][node.y] = 3;
            activate(count+1, i+1);
            grid[node.x][node.y] = 2;
        }
        
        
        
    }
    
    // 바이러스 퍼트리기
    public void BFS() {
        copy = new int[n][n];
        time = new int[n][n];
        for(int i = 0; i < n; i++) {
           copy[i] = grid[i].clone();
           Arrays.fill(time[i], -1);
        }

        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(copy[i][j] == 3) {
                    time[i][j] = 0;
                    queue.add(new Node(i,j));
                }
            }
        }
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 한번 돌때마다 1회 퍼진 것
            for(int i = 0; i < size; i++) {
                Node now = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && (copy[nx][ny] == 0 || copy[nx][ny] == 2)) {
                        time[nx][ny] = time[now.x][now.y]+1;
                        copy[nx][ny] = 3;
                        queue.add(new Node(nx,ny));
                    }
                }
            }
        }
        
        // 모든 영역을 돌았는지 확인
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // 감염이 실패한 경우엔 answer 냅두기 
                if (grid[i][j] == 0 && time[i][j] == -1) return; 
            }
        }
       
        
        int maxTime = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                maxTime = Math.max(time[i][j], maxTime); 
                }
            }
        }
        answer = Math.min(maxTime, answer);
    }
    
}

class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}