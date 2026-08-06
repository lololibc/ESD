package esd;

public class Main {
    static void main() {


        Agenda agenda = new Agenda(10);
        Contato c1 = new Contato("ana", "999");
        Contato c2 = new Contato("amanda", "989");

        agenda.adicionar(c1);
        //IO.println(agenda.listar());

        agenda.adicionar(c2);
        //IO.println(agenda.listar());

        agenda.buscarPrefixo("9");
        agenda.atualizar(c1, "joao", "909");

        IO.println(agenda.listar());


    }
}
