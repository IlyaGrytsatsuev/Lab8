package Main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        long SumTime = 0;
        long best_time = 0;
        int ThreadNum = 0;

        UsualMatrix a = new UsualMatrix(1000, 1000);
        UsualMatrix b = new UsualMatrix(1000, 1000);



        int type = 0;
        int random = 0;

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Random rand = new Random();

                random = 1 + rand.nextInt(9);

                a.set(i, j, random);

                // b.set(i, j, random);

            }
        }

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                Random rand = new Random();

                random = 1 + rand.nextInt(9);

                b.set(i, j, random);

            }
        }

        SumTime = System.currentTimeMillis();
        a.product(b);
        SumTime = System.currentTimeMillis() - SumTime;
        System.out.println("UsualMatrix:");
       // System.out.println(a.product(b) + "\n");
        System.out.println("Product time:");
        System.out.println(SumTime + "\n");

        System.out.println("ParallelMatrix:");
        for(int i = 1; i <=10; i++) {
            if (a.getRows() % i == 0) {
                ParallelMatrixProduct c = new ParallelMatrixProduct(i, a, b);
                SumTime = System.currentTimeMillis();
                c.product();
                SumTime = System.currentTimeMillis() - SumTime;

                if(i == 1)
                    best_time = SumTime;

                if(SumTime < best_time) {
                    best_time = SumTime;
                    ThreadNum = i;
                }
               // System.out.println("MultiThread Matrix:");
                // System.out.println(c.product());
                System.out.println("Product time per " + i + "thread");
                System.out.println(SumTime + "\n");
            }
        }
        System.out.println("MultiThread Matrix:");
        System.out.println("Best Product time:");
        System.out.println(best_time + " by " + ThreadNum + " Threads");
        System.out.println( ThreadNum + " Threads:");

    }
}