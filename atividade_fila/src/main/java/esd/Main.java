package esd;

public class Main {
    static void main() {


        Servidor servidor1 = new Servidor(1000, 300, 500);

        servidor1.executar(50000);
        IO.println(servidor1.toString());



        Servidor servidor2 = new Servidor(10000, 3000, 5000);

        servidor2.executar(5000);
        IO.println(servidor2.toString());
    }




}
