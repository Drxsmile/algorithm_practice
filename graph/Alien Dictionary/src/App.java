import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        String[] dic = { "wrt", "wrf", "er", "ett", "rftt" };
        String res = findAlienSort(dic);
        System.out.println(res);
        System.out.println(res.equals("wertf"));
        String res2 = alienOrder(dic);
        System.out.println(res2);
    }

    private static String findAlienSort(String[] dic) {
        Map<Character, HashSet<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (int i = 0; i < dic.length; i++) {
            String word = dic[i];
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                }
                if (!inDegree.containsKey(c)) {
                    inDegree.put(c, 0);
                }
            }
        }
        for (int i = 0; i < dic.length - 1; i++) {
            String cur = dic[i];
            String next = dic[i + 1];
            int len = Math.min(cur.length(), next.length());
            int j;
            for (j = 0; j < len; j++) {
                char c = cur.charAt(j);
                char d = next.charAt(j);
                if (c != d) {
                    HashSet<Character> hs = graph.get(c);
                    hs.add(d);
                    // graph.put(c, hs);
                    inDegree.put(d, inDegree.get(d) + 1);
                    break;
                }
            }
            if (j == len && cur.length() > next.length())
                return "";
        }
        Queue<Character> q = new LinkedList<>();
        int cnt = 0;
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                q.offer(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character cur = q.poll();
            cnt++;
            sb.append(cur);
            for (char c : graph.get(cur)) {
                inDegree.put(c, inDegree.get(c) - 1);
                if (inDegree.get(c) == 0)
                    q.offer(c);
            }
        }
        return cnt == graph.size() ? sb.toString() : "";

    }

    // 逆邻接表
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> hm = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            char[] wordArray = word.toCharArray();
            for (char c : wordArray) {
                set.add(c);
            }
        }
        for (Character c : set) {
            hm.put(c, new HashSet<Character>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            int minLen = Math.min(words[i].length(), words[i + 1].length());
            int j = 0;
            for (j = 0; j < minLen; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    hm.get(words[i + 1].charAt(j)).add(words[i].charAt(j));
                    break;
                }
            }
            if (j == minLen && words[i].length() > words[i + 1].length())
                return "";
        }
        for (Map.Entry<Character, Set<Character>> entry : hm.entrySet()) {
            if (entry.getValue().isEmpty()) {
                queue.add(entry.getKey());
                result.append(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            for (Map.Entry<Character, Set<Character>> entry : hm.entrySet()) {
                if (entry.getValue().contains(c)) {
                    entry.getValue().remove(c);
                    if (entry.getValue().isEmpty()) {
                        queue.add(entry.getKey());
                        result.append(entry.getKey());
                    }
                }
            }
        }
        String finalResult = result.toString();
        if (finalResult.length() == set.size()) {
            return finalResult;
        } else {
            return "";
        }
    }
}
