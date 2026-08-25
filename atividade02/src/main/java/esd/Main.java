package esd;

import java.util.Formattable;
import java.util.Random;

public class Main {
    static void main() {


        Random random = new Random();


        Vetor<Integer> vetor = new Vetor<>(10);

        for (int i = 0; i < vetor.getLength(); i++) {
            int valorSorteado = random.nextInt(200);
            vetor.inserirOrdenado(valorSorteado);
        }

        vetor.inserirOrdenado(20);

//        vetor.buscarBinaria()
        vetor.imprimir();
        vetor.buscarBinaria(20);

    }
}
