package Main;

import java.util.*;

public class ParallelMatrixProduct {

    public class MatrixThread extends Thread {

        private int ThreadCount;

        public MatrixThread(String name, int ThreadCount_) {
            super(name);
            ThreadCount = ThreadCount_;

        }

        public void run() {
            int rows_limit = 0;
            int lines = 0;
            int ThreadIndex = 0;
            int Lines_per_Thread = first_mat.rows/ ThreadNum;

            lines = Lines_per_Thread * ThreadCount;
            ThreadIndex = lines - Lines_per_Thread;


            for (; ThreadIndex < lines; ThreadIndex++) {
                for (int j = 0; j < first_mat.columns; j++) {
                    for (int k = 0; k < first_mat.columns; k++) {
                        res.set(ThreadIndex, j, (res.get(ThreadIndex, j) +
                                first_mat.get(ThreadIndex, k) * second_mat.get(k, j)));
                    }
                }
            }
        }
    }

    private int ThreadNum = 0;
    private UsualMatrix first_mat;
    private UsualMatrix second_mat;
    private LinkedList<MatrixThread> threadList;
    private UsualMatrix res;


    public ParallelMatrixProduct(int ThreadNum_, UsualMatrix a, UsualMatrix b) {
        ThreadNum = ThreadNum_;
        first_mat = a;
        second_mat = b;
        res = new UsualMatrix(first_mat.rows, second_mat.columns);
        threadList = new LinkedList<>();
    }

    public UsualMatrix product() {
        for (int i = 1; i <= ThreadNum; i++) {
            MatrixThread thread = new MatrixThread(("thread #" + i), i);
            threadList.add(thread);
            thread.start();

        }
        try {
            ListIterator it = threadList.listIterator();
            while (it.hasNext()) {
                Thread tmp = (Thread) it.next();
                tmp.join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}



