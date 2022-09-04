package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class Combinations {

    public class CombThread extends Thread{
        public int ThreadCount ;
        //private int [] [] comb ;
        private int [] values;
        private int [] res;
        int k;
        int n;
        int j;
        int size;

        public CombThread(String name, int ThreadCount_, int k_, int n_) {
            super(name);
            ThreadCount = ThreadCount_;
            k = k_;
            n = n_;

            values = new int [n];
            for(int i = 0; i < n; i++)
                values[i] = i;
           // j = 0;

        }

        public void generate(int i_,int len) {
           // int i = 0;

            for(;i_ < len; i_++) {
                int index = i_;
                for(j = 0; j < n; j++){
                     comb[i_][j] = values[index%n];
                     index/=n;
                    }
                }
            }


        public void run(){
            int length = 0;
            int ThreadIndex = 0;

            int LengthPerThread = (int)Math.pow(n,k)/ ThreadNum;

            length = LengthPerThread * ThreadCount;
            ThreadIndex = length - LengthPerThread;
            generate(ThreadIndex, length);


        }



    }



    private int n;
    private int k;
    private int [] [] comb ;
    private int ThreadNum;
    private int [] val;

    private LinkedList<CombThread> ThreadList = new LinkedList<>()  ;

    public Combinations(int k_, int n_, int ThreadNum_) {
        //comb = new int [k_];
        k = k_;
        n = n_;
        ThreadNum = ThreadNum_;
        comb = new int[(int)Math.pow(k,n)][n];
        LinkedList<CombThread> ThreadList = new LinkedList<>() ;
        val = new int [n];
        for(int i = 0; i < n; i++)
            val[i] = i;
    }

    public void start_generate(){

        for (int i = 1; i <= ThreadNum; i++) {
            CombThread thread = new CombThread(("thread #" + i), i, k, n);
            ThreadList.add(thread);
            thread.start();
        }
        try {
            ListIterator it = ThreadList.listIterator();
            while (it.hasNext()) {
                Thread tmp = (Thread) it.next();
                tmp.join();

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void MonoGenerate() {
        // int i = 0;

        for(int i = 0 ;i < Math.pow(n,k); i++) {
            int index = i;
            for(int j = 0; j < n; j++){
                comb[i][j] = val[index%n];
                index/=n;
            }
        }
    }

    public void out(){
        for(int i = 0; i < Math.pow(k,n) ; i++) {
            System.out.print("\n");
            for (int j = 0; j < k; j++) {
                    System.out.print(comb[i][j] + " ");
                }
            }
        }



}