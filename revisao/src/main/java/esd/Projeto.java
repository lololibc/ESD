package esd;

import java.util.ArrayList;

public class Projeto {
    protected String nome;
    protected ArrayList<Funcionario> funcionarios;
    protected Gerente gerente;
    private double custoTotal;

    public Projeto(String nome, ArrayList<Funcionario> funcionarios, Gerente gerente) {
        this.nome = nome;
        this.funcionarios = funcionarios;
        this.gerente = gerente;
        this.gerente.salario += ((gerente.salarioBase * 0.01) * funcionarios.size());
    }

    public void adicionarFuncionario(Funcionario f){
        funcionarios.add(f);
    }

    public void finalizar(){
        this.gerente.salario += (gerente.salarioBase * 0.1);
        for (Funcionario f : funcionarios) {
            f.salario += (f.salarioBase * 0.1);
            custoTotal += (f.salarioBase * 0.1 + gerente.salario);
        }
    }

    public double getSalarioGerente(){
        return gerente.salario;
    }
    public double getSalarioFuncionario(){
        for (Funcionario f : funcionarios) {
            custoTotal += f.salario;
        }
        return custoTotal;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "Nome:'" + nome + '\n' +
                ", funcionarios:" + funcionarios +
                ", gerente=" + gerente +
                "Custo total:'" + custoTotal;
    }
}
