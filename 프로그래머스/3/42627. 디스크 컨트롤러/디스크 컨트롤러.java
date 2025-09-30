import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] jobs) {
        // 우선순위 높은 순으로 꺼냄 -> 우선순위큐
        // 요청부터 종료까지 걸린 시간의 평균을 return
        // jobs[i][0]은 요청 시간, jobs[i][1]은 소요 시간
        PriorityQueue<Job> heap = new PriorityQueue<>();
        
        // 요청~종료 시간 배열
        int[] times = new int[jobs.length];
        int index = 0;
        int finJob = 0;
        int total = 0;
        
        // 요청 시간대로 정렬을 해야하므로, 순번을 유지하기 위한 배열 생성
        int[][] jobsArr = new int[jobs.length][3];
        for (int i = 0; i < jobs.length; i++) {
           jobsArr[i][0] = i;        // 작업 번호
           jobsArr[i][1] = jobs[i][0]; // 요청 시각
           jobsArr[i][2] = jobs[i][1]; // 소요 시간
        }
        
        Arrays.sort(jobsArr, (a,b) -> a[1] - b[1]);
        
        while(index < jobs.length || !heap.isEmpty()) {
            // 현재 도달 시간보다 적은 요청 시간에 들어온 작업들 큐에 넣기
            while(index < jobs.length && finJob >= jobsArr[index][1]) {
                heap.add(new Job(jobsArr[index][0], jobsArr[index][1], jobsArr[index][2]));
                index++;
            }
            
            if(heap.isEmpty()) {
                // heap에 든게 없다면 다음 요청을 넣어야하므로 finJob 점프
                finJob = jobsArr[index][1];
                continue;
            }
            // 작업 하나 뽑아서 실행
            Job job = heap.poll();
            finJob += job.spendTime;
            total += (finJob - job.requestTime);     
        }
        
        int answer = total/index;
        return answer;
    }
}

// 순번, 요청시간, 소요시간
// 작업 소요시간이 짧은 것 > 작업의 요청 시각이 빠른 것 > 작업의 번호가 작은 것 순으로 정렬 조건 override
class Job implements Comparable<Job> {
    int num;
    int requestTime;
    int spendTime;
    
    public Job(int num, int requestTime, int spendTime) {
        this.num = num;
        this.requestTime = requestTime;
        this.spendTime = spendTime;
    }
    
    @Override
    public int compareTo(Job o) {
        if(this.spendTime == o.spendTime) {
            if(this.requestTime == o.requestTime) {
                return this.num - o.num;
            } else {
                return this.requestTime - o.requestTime;
            }
        }
        return this.spendTime - o.spendTime;
    }
}