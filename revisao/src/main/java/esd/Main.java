package esd;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ArrayList<Funcionario> funcionariosp1 = new ArrayList<>();
        Gerente jose = new Gerente("Jose");

        funcionariosp1.add(new Funcionario("pedro"));
        funcionariosp1.add(new Funcionario("marcio"));
        Projeto p1 = new Projeto("projeto1", funcionariosp1, jose);

        IO.println(p1.toString());
    }
}
