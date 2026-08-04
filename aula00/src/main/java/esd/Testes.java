package esd;

public class Testes {
    static void main() {
        VetorEstatico vetor = new VetorEstatico(10);
        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("D");
        vetor.imprimir();
        vetor.inserir(4,"E");
        vetor.imprimir();
        vetor.removerUltimo();
        vetor.imprimir();
        vetor.obterTamanho();
        vetor.remover(2);
        vetor.imprimir();
        vetor.remover("A");
        vetor.imprimir();
    }
}
