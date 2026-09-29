package esd;

import java.util.Random;

public class Requisicao implements Comparable<Requisicao> {

    private int id;
    static int[] ids;
    private static Random aleatorio;


    public Requisicao(int id) {
        this.id = id;
    }


    @Override
    public int compareTo(Requisicao o) {
        return 0;
    }
}
