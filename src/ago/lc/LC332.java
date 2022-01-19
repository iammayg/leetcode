package ago.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//todo 未做完
public class LC332 {
    static Map<String, Integer> keyMap;
    static Map<Integer, String> valueMap;
    static int N;
    static int count;
    static int[] h;
    static int[] e;
    static int[] ne;
    static int inx;
    static int[][] st;
    static List<String> resList;

    static void addKey(List<List<String>> tickets) {
        List<String> keyList = new ArrayList<>();
        for (List<String> i : tickets) {
            for (String j : i) {
                if (!keyList.contains(j)) {
                    keyList.add(j);
                }
            }
        }
        Collections.sort(keyList);
        for (int i = 0; i < keyList.size(); i++) {
            keyMap.put(keyList.get(i), i);
            valueMap.put(i, keyList.get(i));
        }
        N = keyList.size() + 10;
        count = keyList.size();
    }

    static int getP(String key) {
        return keyMap.get(key);
    }

    static String getKey(int value) {
        return valueMap.get(value);
    }

    static void add(int a, int b) {
        e[inx] = b;
        ne[inx] = h[a];
        h[a] = inx;
        inx++;
        st[a][b] = 1;
    }

    static void dfs(int u, List<String> resList) {
        resList.add(getKey(u));
        int minNextValue = Integer.MAX_VALUE;
        int nextP = -1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (st[u][j] == 1 && e[i] < minNextValue) {
                minNextValue = e[i];
                nextP = j;
            }
        }
        if (nextP != -1) {
            st[u][nextP] = 0;
            dfs(nextP, resList);
        }
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        addKey(tickets);
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        st = new int[N][N];
        inx = 0;
        Arrays.fill(h, -1);

        for (List<String> i : tickets) {
            add(getP(i.get(0)), getP(i.get(1)));
        }
        resList = new ArrayList<>();
        dfs(getP("JFK"), resList);
        return resList;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> list1 = Arrays.asList("JFK","KUL");
        List<String> list2 = Arrays.asList("JFK","NRT");
        List<String> list3 = Arrays.asList("NRT","JFK");
//        List<String> list4 = Arrays.asList("ATL", "JFK");
//        List<String> list5 = Arrays.asList("ATL", "SFO");
        tickets.add(list1);
        tickets.add(list2);
        tickets.add(list3);
//        tickets.add(list4);
//        tickets.add(list5);
        System.out.println(findItinerary(tickets));
    }
}
