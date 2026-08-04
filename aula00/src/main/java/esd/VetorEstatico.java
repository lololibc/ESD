package esd;

import java.util.Arrays;

public class VetorEstatico {

    private String[] elementos;
    private int tamanho;

    public VetorEstatico(int quantidade) {
        this.elementos = new String[quantidade];
    }

//    public void inserir(String elemento) {
//        for (int i = 0; i< elementos.length; i++) {
//            if (elementos[i] == null) {
//                elementos[i] = elemento;
//                return;
//            }
//        }
//    }

    public void inserir (String elemento) {
        if(tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
        } else {
            IO.println("Vetor ta cheio!");
        }

    }

    public void inserir (int indice, String elemento) {
        if (tamanho >= elementos.length) {
            IO.println("Vetor Cheio!");
            return;
        }

        if (indice < 0 || indice > elementos.length){
            IO.println("Posição Inválida!");
            return;
        }

        for (int i = tamanho; i > indice ; i--) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public void removerUltimo() {
        if (tamanho > 0) {
            elementos[tamanho - 1] = null;
            tamanho--;
        }
    }

    public void obterTamanho() {
        IO.println(tamanho);
    }

    public void imprimir() {
        IO.print("[");
        for (int i = 0; i < elementos.length; i++) {
            IO.print(elementos[i]);
            IO.print(",");
        }
        IO.println("]");
    }

    public void remover(int indice){
        if (indice < 0 || indice>= tamanho){
            System.out.println("indice inválido");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
    }

    public void remover(String elemento){
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)){
                remover(i);
                return;
            }
        }
    }
}
