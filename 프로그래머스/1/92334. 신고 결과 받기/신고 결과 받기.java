import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템
        // 각 유저는 한 번에 한 명의 유저를 신고, 신고 횟수에 제한 x, 서로 다른 유저를 계속 신고 가능
        // 한 유저가 한 유저를 여러 번 신고할 수도 있지만, 동일 유저에 대한 신고 횟수는 1회로 처리
        // K번 이상 신고된 유저는 게시판 이용 정지, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송 (신고한 모든 내용 취합)
        
        // 즉, k번이 넘어 정지가 된다면, 해당 유저를 신고한 유저들에게 메일이 감
        // id_list - 이용자 아이디
        // report - "신고한사람 신고당한사람"
        // k - 정지 기준이 된 횟수
        // 각 유저가 메일을 받은 횟수 배열을 return
        
        // 2 <= id_list <= 1000
        // 1 <= report <= 2000
        
        // 필요한 정보는 각 유저별로 신고당한 횟수, 이를 신고한 사람 List
        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Set<String>> listMap = new HashMap<>();
        Map<String, Integer> mailMap = new HashMap<>();
        
        // 맵 세팅
        for(String id : id_list) {
            countMap.put(id, 0);
            mailMap.put(id, 0);
            listMap.put(id, new HashSet<>());
        }
        
        for(String s : report) {
            String[] arr = s.split(" ");
            // 중복 신고의 경우에는 횟수 증가 X
            if(listMap.get(arr[1]).add(arr[0])) {
                countMap.put(arr[1], countMap.getOrDefault(arr[1],0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        
        // 신고를 한 사람이 메일을 받은 횟수, 즉, 2가 넘는다면, 그 대상을 신고한 사람을 찾아 메일 횟수를 ++ 해줘야함.
        int index = 0;
        for(String id : id_list) {
            if(countMap.get(id) >= k) {
                for (String mail : listMap.get(id)) {
                    mailMap.put(mail, mailMap.get(mail) + 1);
                }
            }
        }
        
        for(String id : id_list) {
            answer[index] = mailMap.get(id);
            index++;
        }
        
        return answer;
    }
}