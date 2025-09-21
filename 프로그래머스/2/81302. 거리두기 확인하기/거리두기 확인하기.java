import java.io.*;
import java.util.*;

class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int[] solution(String[][] places) {
        // 두 테이블 T1, T2가 행렬 (r1, c1), (r2, c2)에 각각 위치하고 있다면, T1, T2 사이의 맨해튼 거리는 |r1 - r2| + |c1 - c2| 입니다.
        // 해당 맨해튼 거리가 2이하이면 안됨. 3부터 가능
        // 자리 사이에 파티션이 있다면 2 이하도 가능, 단, 가는 경로 모두에 파티션이 있어야함
        // P는 응시자, O는 테이블, X는 파티션
        // 모든 응시자가 거리두기를 잘 지키면 1, 한명이라도 안지키면 0 return
        // 일단 2차원 grid로 변환해주고 탐색을 시작해야할듯 - 돌면서 P를 만나면 상하좌우 4방향으로 탐색 뻗어나가기
        // 맨해든 거리 2까지의 거리는 파티션이 있는지 없는지 심층 탐색
        // 맨해튼 거리는 결국엔 이동 횟수. (대각선은 2니까 상하좌우로만 움직일 수 있다고 생각)
        // 그 이후에는 P를 만나도 무조건 거리두기이므로 넘어가도 될듯
        // 그러려면 BFS가 좀 더 편할듯하다. 레벨 2까지만 심층검색 -> 만약 2까지 탐색했는데 P에 갈 수 없다면 거리두기 O
        // 자기 자신으로 돌아가면 안됨 + 경우의 수를 최대한 줄여야하므로 visited 배열 필요 
        
        int n = places.length;
        int m = places[0].length;
        int[] answer = new int[n];
        
        // 모든 대기실마다 해당 배열을 만들어야함
        
        for (int room = 0; room < 5; room++) {
            char[][] grid = new char[5][5];
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    grid[i][j] = places[room][i].charAt(j);
                }
            }
            // BFS 시작
            boolean[][] visited = new boolean[5][5];
            answer[room] = BFS(grid, visited);
        }
        return answer;
    }
    
    public int BFS(char[][] grid, boolean[][] visited) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(grid[i][j] == 'P') {
                    Queue<Node> queue = new LinkedList<>();
                    queue.add(new Node(i,j));
                    visited[i][j] = true;
                    int count = 0;
                    
                    while(!queue.isEmpty() && count < 2) {
                    int size = queue.size();
                    // 레벨을 나누기위해 size로 반복 탐색
                    for(int k = 0; k < size; k++) {
                        Node now = queue.poll();
                        for(int z = 0; z < 4; z++) {
                            int nx = now.x + dx[z];
                            int ny = now.y + dy[z];
                            // 사이에 파티션이 있는지 없는지 확인하는 변수가 필요할 것 같은데..
                            // 벽이라면 확장 안하면 어차피 상관없음. 
                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || visited[nx][ny] == true) continue;
                            if (grid[nx][ny] == 'P') {
                                // 파티션 없이 P를 만났으므로 0 return
                                return 0;
                            }
                            if (grid[nx][ny] == 'O') {
                                 visited[nx][ny] = true;
                                 queue.add(new Node(nx, ny));
                            }
                        }
                    }
                    count++;
                    }
                }
            }
        }
        return 1;
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