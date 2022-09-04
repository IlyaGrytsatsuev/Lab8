package Main;

public class MainComb {
    public static void main(String[] args) {
        int time = 0;

        Combinations a = new Combinations(6,6, 1);
        time = (int)System.currentTimeMillis();
        a.MonoGenerate();
        time = (int) System.currentTimeMillis() - time;


        System.out.println("Monothread: " + time);



        Combinations b = new Combinations(6,6, 2);
        time = (int)System.currentTimeMillis();
        b.start_generate();
        time = (int)System.currentTimeMillis() - time;
        System.out.println("Multithread: " + time);

       // b.out();

        //int j = 0;


    }
}
