package libs;


import java.util.*;

import static java.lang.Math.max;

public class PQueue<T> {
    T[] a;
    int n;
    Comparator<T> compare;
    PQueue(Comparator<T> comparator){
        compare = comparator;
        n = 0;
        a = (T[]) new Object[1];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    boolean add(T x) {
        if (n + 1 > a.length) resize();
        a[n++] = x;
        bubbleUp(n - 1);
        return true;
    }

    T remove() {
        T x = a[0];
        a[0] = a[--n];
        trickleDown(0);
        if (3 * n < a.length) resize();
        return x;
    }

    void bubbleUp(int i) {
        int p = parent(i);
        while (i > 0 && compare.compare(a[i], a[p]) < 0) {
            swap(i, p, a);
            i = p;
            p = parent(i);
        }
    }

    static void swap(int i, int j, Object []a){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp ;
    }

    void trickleDown(int i) {
        do {
            int j = -1;
            int r = right(i);
            int l = left(i);
            if (r < n && compare.compare(a[r], a[i]) < 0) {
                if (compare.compare(a[l], a[r]) < 0) {
                    j = l;
                } else {
                    j = r;
                }
            } else {
                if (l < n && compare.compare(a[l], a[i]) < 0) {
                    j = l;
                }
            }
            if (j >= 0) swap(i, j, a);
            i = j;
        } while (i >= 0);
    }

    void resize() {
        T []b = (T[]) new Object[max(2*n, 1)];
        if (n >= 0) System.arraycopy(a, 0, b, 0, n);
        a = b;
    }

    boolean isEmpty(){
        return n == 0;
    }
    /*
    usage
    public static void main(String[] args) {
        PQueue<Pair<Integer, Integer>> p = new PQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int comp = o2.getKey().compareTo(o1.getKey());
                if(comp != 0) return comp;
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Pair<Integer, Integer> a = new Pair<>(3,5);
        Pair<Integer, Integer> b = new Pair<>(3,4);
        Pair<Integer, Integer> c = new Pair<>(3,2);
        Pair<Integer, Integer> d = new Pair<>(2,1);
        p.add(a);
        p.add(b);
        p.add(c);
        p.add(d);
        while(!p.isEmpty()){
            Pair pp = p.remove();
            System.out.println(pp.getKey() + " " + pp.getValue());
        }
    }
     */
}
