package javaCode.list;

import java.util.ArrayList;
import java.util.Iterator;

public class SequenceList<T> implements Iterable<T> {

    public static void main(String[] args) {

        {// test1
         // SequenceList<String> sl = new SequenceList<String>(10);
         // sl.insert("test1");
         // sl.insert("test2");
         // sl.insert("test3");
         // sl.insert(1, "test02");
         // for(String s : sl){
         // System.out.println(s);
         // }
         // System.out.println("--------------------");
         // String getone = sl.get(1);
         // System.out.println("now get => " + getone);
         // String remone = sl.remove(0);
         // System.out.println("now remove => " + remone);
         // sl.clear();
         // System.out.println("after clear => " + sl.length());
        }

        // {// test2
        //     SequenceList<String> sl2 = new SequenceList<String>(3);
        //     sl2.insert("test0");
        //     sl2.insert("test1");
        //     sl2.insert("test2");
        //     sl2.insert("test3");
        // }


    }

    

    private T[] eles;
    private int N;

    public SequenceList(int capacity) {
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear() {
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        return eles[i];
    }

    public void insert(int i, T t) {
        if(N == eles.length) resize(2 * eles.length);
        for (int j = N; j > i; j--) {
            eles[j] = eles[j - 1];
        }
        eles[i] = t;
        N++;
    }

    public void insert(T t) {
        if(N == eles.length) resize(2 * eles.length);
        eles[N++] = t;
    }

    public T remove(int i) {
        T cur = eles[i];

        for (int j = i; j < N - 1; j++) {
            eles[j] = eles[j + 1];
        }

        N--;
        if(N<eles.length/4) resize(eles.length/2);
        return cur;
    }

    public int indexOf(T t) {
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t))
                return i;
        }

        return -1;
    }

    public void resize(int newSize){
        T[] temp = eles;
        eles = (T[])new Object[newSize];
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    private class SIntertor implements Iterator {
        private int cusor;

        public SIntertor() {
            this.cusor = 0;
        }

        @Override
        public boolean hasNext() {
            return cusor < N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub

        return new SIntertor();
    }

}