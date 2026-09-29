package esd;

import java.util.Random;

public class Servidor {

    private int totalReqGeradas = 0;
    private int totalReqAtendidas = 0;
    private int totalReqPerdidas = 0;
    private Random aleatorio = new Random();
    private Fila<Requisicao> fila;
    private int numProcessadores;
    private int n;
    private int numReq = 0;

    public Servidor(int capacidade, int numProcessadores, int n) {
        this.fila = new Fila<>(capacidade) ;
        this.numProcessadores = numProcessadores;
        this.n = n;
    }

    public  void executar (int ciclos){
        for (int ciclo = 1; ciclo <= ciclos ; ciclo++) {

            //novas req
            int novasReq = aleatorio.nextInt(1, n);
            for (int i = 0; i < novasReq; i++) {
                Requisicao nova = new Requisicao(++numReq);
                totalReqGeradas++;

                if (fila.estaCheia()){
                    totalReqPerdidas++;
                }else{
                    fila.enfileirar(nova);
                }
            }

            //atender
            for (int i = 1; i < numProcessadores; i++) {
                if (!fila.isEmpty()){
                    fila.desenfileirar();
                    totalReqAtendidas++;
                }
            }

        }
    }

    @Override
    public String toString() {
        double porcento = (((double) totalReqPerdidas /totalReqGeradas)*100);
        return "Servidor{" +
                "totalReqGeradas=" + totalReqGeradas +
                ", totalReqAtendidas=" + totalReqAtendidas +
                ", totalReqPerdidas=" + totalReqPerdidas +
                ", numProcessadores=" + numProcessadores +
                ", n=" + n +
                ", % das req perdidas: " + porcento + "%"+
                '}';
    }
}
