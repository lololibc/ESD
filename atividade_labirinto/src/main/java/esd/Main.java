package esd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Labirinto labirinto = new Labirinto();
        boolean achou = labirinto.resolver();
        System.out.println(achou ? "Caminho encontrado!" : "Sem solução.");
        labirinto.imprimir();

    }
}
