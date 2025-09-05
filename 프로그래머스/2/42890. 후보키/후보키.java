import java.util.*;

class Solution {
    List<List<Integer>> combination = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        backtracking(relation, 0, new ArrayList<>());
        combination.sort(Comparator.comparingInt(List::size));
        Set<Set<Integer>> minimal = new HashSet<>();
        for(List<Integer> list : combination) {
            List<String> check = new ArrayList<>();
            if(isMinimal(minimal, list)) {
            for(int i = 0; i < relation.length; i++) {
                String s = "";
                for(int j = 0; j < list.size(); j++) {
                    s += relation[i][list.get(j)] + ",";
                }
                check.add(s);
            }
            if(checkDuplicate(relation, check)) {
                answer++;
                minimal.add(new HashSet<>(list));
        }
            }
    }
         return answer;
    }
    
    public void backtracking(String[][] relation, int start, List<Integer> list) {
        if(list.size() > 0) {
            combination.add(new ArrayList<>(list));
        }
        // 최소성 - combination에 이미 있고, 그게 유일성을 만족한다면, 거기에서 추가된 애들은 세면 안됨 (1,2) - 유일성 만족이면 (1,2,3) - 최소성 만족 X
        
        for(int i = start; i < relation[0].length; i++) {
            list.add(i);
            backtracking(relation, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
    
    public boolean checkDuplicate(String[][] relation, List<String> list) {
        Set<String> set = new HashSet<>();
        for(String s : list) {
            if(!set.add(s)) return false;
        }
        return true;
    }
        
    public boolean isMinimal(Set<Set<Integer>> minimal, List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for(Set<Integer> a : minimal) {
            if(set.containsAll(a)) return false;
        }
        return true;
    }
}