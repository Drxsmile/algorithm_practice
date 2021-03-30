import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        String pattern = "abab";
        String str = "redblueredblue";
        boolean res = solution(pattern, str);
        System.out.println(res);
        // better solution
        boolean res2 = wordPatternMatch(pattern, str);
        System.out.println(res2);
    }

    public static boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    private static boolean isMatch(String str, int i, String pattern, int j, Map<Character, String> map,
            Set<String> set) {
        if (i == str.length() && j == pattern.length())
            return true;
        if (i == str.length() || j == pattern.length())
            return false;
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (!str.startsWith(s, i))
                return false;
            else
                return isMatch(str, i + s.length(), pattern, j + 1, map, set);
        }
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            if (set.contains(p)) {
                continue;
            }
            map.put(c, p);
            set.add(p);
            if (isMatch(str, k + 1, pattern, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }

    private static boolean solution(String pattern, String str) {
        int len = pattern.length();
        if (str.length() < len)
            return false;
        char[] c = pattern.toCharArray();
        List<String[]> res = new LinkedList<>();
        dfs(res, new String[len], str, 0);
        for (String[] s : res) {
            if (legal(c, s))
                return true;
        }
        return false;
    }

    private static void dfs(List<String[]> res, String[] path, String str, int index) {
        if (index == path.length) {
            res.add(Arrays.copyOf(path, path.length));
            return;
        }
        int l1 = str.length();
        int l2 = path.length - index - 1;
        int l = l1 - l2;
        for (int i = 1; i <= l; i++) {
            path[index] = str.substring(0, i);
            dfs(res, path, str.substring(i), index + 1);
            path[index] = null;
        }
    }

    private static boolean legal(char[] c, String[] s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map1 = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(c[i])) {
                map.put(c[i], s[i]);
            } else {
                String cur = map.get(c[i]);
                if (!cur.equals(s[i]))
                    return false;
            }
            if (!map1.containsKey(s[i])) {
                map1.put(s[i], c[i]);
            } else {
                char cur = map1.get(s[i]);
                if (cur != c[i])
                    return false;
            }
        }
        return true;
    }
}

