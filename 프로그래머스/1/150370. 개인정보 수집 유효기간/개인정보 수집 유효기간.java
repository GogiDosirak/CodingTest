import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 개인정보 1~n번 총 n개
        // 각 약관마다 개인정보 보관 유효기간이 정해져있음, 유효기간이 지났다면 반드시 파기
        // ex) 2021.01.05에 수집 -> 1년 A 약관 -> 2022.01.05에 파기해야함
        // 모든 달은 28일까지 있다고 가정
        
        // 오늘 날짜로 파기해야 할 개인정보 번호들을 구하는 문제
        // today - 오늘 날짜
        // terms - 약관 (A 개월)
        // privacies - 가입날짜와 약관 (2019.01.01 D)
        
        // 약관 - 개월 수 Map으로 관리
        // privacies를 돌면서 해당 약관일 때, 만료됐는지 확인 -> 만료됐다면 인덱스+1을 answer에 넣기 (1번부터 시작하므로)
        
        // 약관 - 개월 Map 세팅
        Map<String, Integer> map = new HashMap<>();
        for(String term : terms) {
            String[] arr = term.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            String registerDate = arr[0];
            String term = arr[1];
            
            // 유효 개월 수 가져오기
            int expireMonth = map.get(term);
            
            // 만료된 개인정보라면 파기 (list에 저장)
            // 각각 분리 후 int로 변환 -> 개월을 더하고 (12이 넘는다면 년도 +) 다시 .을 붙여 String으로 변환
            String[] dateArr = registerDate.split("\\.");
            // dateArr[0] - 년도, dateArr[1] - 월, dateArr[2] - 일
            int calculatedMonth = Integer.parseInt(dateArr[1]) + expireMonth;
            if(calculatedMonth >= 12) {
                // 몫만큼 년도에 더해주고 (12월인 경우 1이 더 남으므로 -1 해서 나누기)
                dateArr[0] = String.valueOf(Integer.parseInt(dateArr[0]) + (calculatedMonth - 1) / 12);
                // 나머지만큼이 월
                dateArr[1] = String.valueOf((calculatedMonth - 1) % 12 + 1);
            } else {
                dateArr[1] = String.valueOf(calculatedMonth);
            }
            
            // 한자릿수인 경우 앞에 0 붙이기
            String finalDate = "";
            if(dateArr[1].length() == 1) {
                finalDate = dateArr[0] + ".0" + dateArr[1] + "." + dateArr[2];
            } else {
                finalDate = dateArr[0] + "." + dateArr[1] + "." + dateArr[2];
            }
            
            // String 대소비교는 사전순이므로, today보다 가입일 + 유효 개월이 크거나 같다면 만료된 것
            // 문자열 비교는 compareTo로 함
            // 사전순 비교에서 앞에 있는 단어는 더 작은 값
            // finalDate가 today보다 작거나 같아야 today를 기준으로 파기해야하는 개인정보
            if(finalDate.compareTo(today) <= 0) list.add(i + 1);
            
        }
        
        
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}