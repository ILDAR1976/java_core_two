package basic_1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class basic_2_1_3 {
    public static void main(String[] args) {
        String[] s = fillSet();
        int n = s.length,m = 1;
        int[] x = fill(n);
        printSequence(x,m,s);
    }
    private static String[] fillSet() {
        String[] x = new String[] {"A","B","C","D"};
        return x;
    }
    private static int[] fill(int n) {
        int[] x = new int[n];
        return x;
    }
    private static void printSequence(int[] x,int n, String[] s) {
        int[][] table = new int[(int)Math.pow(2,x.length)][x.length];
        int[] last = new int[x.length];
        for (int i = 0; i<x.length; i++) last[i] = n;

        boolean l = true; int idx = 0;
        while (l) {
            idx++;
            nextSequence(x,n);
            l = !isEquals(x,last);
            for (int j = 0;j<x.length;j++)
                table[idx][j] = x[j];
        }
        print(s,table);
    }
    private static void nextSequence(int[] x,int n){
        int k = x.length, p = k - 1;
        while (!(x[p] < n )) {
            if (--p < 0) {
                p = 0;
                return;
            }
        }
        x[p]++;
        for (int i = p+1;i < k; i++) x[i] = 0;
    }
    private static boolean isEquals(int[] x, int[] y) {
        boolean equal = true;
        if (x.length != y.length) return !equal;
        for (int i = 0; i < x.length; i++) {
            equal = equal & x[i] == y[i];
        }
        return equal;
    }
    private static void print(int[] x) {
        for (int i = 0;  i<x.length; i++) {
            System.out.print(x[i] + "\t" );
        }
        System.out.println();
    }

    private static void print(String[] s,int[][] t) {
        List<String> list = new ArrayList<>();
        String str = "";
        for (int i = 0;  i<t.length; i++) {
            str = "";
            for (int j = 0;  j<t[0].length; j++) {
                if (t[i][j] == 1) {
                  str += s[j];
                }
            }
            list.add((str=="")?"0,":str+",");
        }

        List<String> out = list.stream().sorted().sorted((o1,o2)-> (o1.length() - o2.length())).collect(Collectors.toList());
        String tmp = out.get(out.size()-1);
        out.remove(list.size()-1);
        out.add(tmp.replace(",",""));
        int i = 1;
        for (String e:out) {
            System.out.print(e);
            if (i++%10 == 0) System.out.println();
        }
    }

}
