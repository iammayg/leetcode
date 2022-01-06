package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LC990 {
    static Map<String, Integer> map;
    static int N = 510;
    static int[] p ;
    static int inx ;

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    /**
     * 方案一：这个解法不对（1。a!=b，这时候ab会在不通连通图，2。a=b这时候ab就会和到同一个连通图）
     * 1.ab都没放入 ： 放入，当前为true，==：合并
     * 2.a放入，b没放入->根据操作符 放入相应集合（==：b放在a集合里，!=：b单独集合
     * 3.都放入了->判断是否正确
     * 3.1错误：返回错误
     * 3.2正确：
     * 3.2.1==合并
     * 3.2.2！=不用管
     */
    //    public static boolean equationsPossible1(String[] equations) {
    //        map = new HashMap<>();
    //        for (int i = 0; i < N; i++) {
    //            p[i] = i;
    //        }
    //        for (String s : equations) {
    //            String a = s.substring(0, 1);
    //            String b = s.substring(3);
    //            String op = s.substring(1, 2);
    //            if (a.equals(b)) {
    //                if (op.equals("!")) {
    //                    return false;
    //                }
    //                if (!map.containsKey(a)) {
    //                    map.put(a, inx++);
    //                }
    //                continue;
    //            }
    //            if (!map.containsKey(a) && !map.containsKey(b)) {
    //                map.put(a, inx++);
    //                map.put(b, inx++);
    //                if (op.equals("=")) {
    //                    p[map.get(b)] = find(map.get(a));
    //                }
    //            } else if (!map.containsKey(a) || !map.containsKey(b)) {
    //                if (map.containsKey(a)) {
    //                    map.put(b, inx++);
    //                    if (op.equals("=")) {
    //                        p[map.get(b)] = find(map.get(a));
    //                    }
    //                } else {
    //                    map.put(a, inx++);
    //
    //                    if (op.equals("=")) {
    //                        p[map.get(a)] = find(map.get(b));
    //                    }
    //                }
    //            } else {
    //                if (op.equals("=")) {
    //                    if (find(map.get(a)) != find(map.get(b))) {
    //                        return false;
    //                    }
    //                    p[find(map.get(a))] = find(map.get(b));
    //                } else {
    //                    if (find(map.get(a)) == find(map.get(b))) {
    //                        return false;
    //                    }
    //                }
    //            }
    //
    //        }
    //        return true;
    //    }
    public static boolean equationsPossible(String[] equations) {
        map = new HashMap<>();
        p=new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
        inx=0;

        List<String> eqList = new ArrayList<>();
        List<String> neqList = new ArrayList<>();
        for (String s : equations) {
            if (s.startsWith("!", 1)) {
                neqList.add(s);
            } else {
                eqList.add(s);
            }
            String a = s.substring(0, 1);
            String b = s.substring(3);
            if (!map.containsKey(a)) {
                map.put(a, inx++);
            }
            if (!map.containsKey(b)) {
                map.put(b, inx++);
            }
        }
        for (String s : eqList) {
            String a = s.substring(0, 1);
            String b = s.substring(3);
            p[find(map.get(a))] = find(map.get(b));
        }
        for (String s : neqList) {
            String a = s.substring(0, 1);
            String b = s.substring(3);
            if (find(map.get(a)) == find(map.get(b))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] s = new String[10];
        s[0] = "g!=a";
        s[1] = "j==a";
        s[2] = "i==d";
        s[3] = "b!=i";
        s[4] = "j!=d";
        s[5]="i==f";
        s[6]="f==h";
        s[7]="k==h";
        s[8]="c!=b";
        s[9]="b==a";
        System.out.println(equationsPossible(s));
    }

}
