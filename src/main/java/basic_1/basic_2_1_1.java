package basic_1;

public class basic_2_1_1 {
    public static void main(String[] args) {
        int[] x = fill();
        int n = 10;
        printSequence(x,n);
    }
    private static int[] fill() {
        int[] x = new int[] {0,0,0,0,0};
        return x;
    }
    private static void printSequence(int[] x,int n) {
        int[] last = new int[x.length];
        for (int i = 0; i<x.length; i++) last[i] = n;
        print(x);
        while (!isEquals(x,last)) {
            nextSequence(x,n);
            print(x);
        }
    }
    private static void nextSequence(int[] x,int n){
        int k = x.length, p = k - 1;
        while (!(x[p] < n)) p--;
        x[p]++;
        for (int i = p+1;i < k; i++) x[i] = 1;
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
}