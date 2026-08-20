package vetor.testes;

import vetor.Produto;
import vetor.Vetor;

import java.util.Random;

public class ex12 {


    static void main() {

        Vetor<Integer> vetor =  new Vetor<>(10);
        inserirAleatorio(vetor, 100, 200);

        vetor.imprimir();

    }

    public static void inserirAleatorio(Vetor<Integer> vetor, int quantidade, int range) {

        Random aleatorio = new Random();
        while (vetor.obterTamanho() < quantidade) {
            int numeroSorteado = aleatorio.nextInt(range);
            vetor.inserirOrdenadov2(numeroSorteado);
        }






    }
}
