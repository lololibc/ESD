package esd.atividade1;

import java.util.ArrayList;

public class Projeto {
    protected String nome;
    protected ArrayList<Funcionario> funcionarios;
    protected Gerente gerente;
    private boolean finalizado;

    public Projeto(String nome, ArrayList<Funcionario> funcionarios, Gerente gerente) {
        this.nome = nome;
        this.funcionarios = funcionarios;
        this.gerente = gerente;
        this.finalizado = false;
        this.gerente.salario += ((gerente.salarioBase * 0.01) * funcionarios.size());
    }

    public void adicionarFuncionario(Funcionario f){
        funcionarios.add(f);
        this.gerente.salario += (gerente.salarioBase * 0.01);
    }

    public void finalizar(){
        if (finalizado) {
            return;
        }
        this.gerente.salario += (gerente.salarioBase * 0.1);
        for (Funcionario f : funcionarios) {
            f.salario += (f.salarioBase * 0.1);
        }
        this.finalizado = true;
    }

    public double getSalarioGerente(){
        return gerente.salario;
    }
    public double getSalarioFuncionarios(){
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.salario;
        }
        return total;
    }

    public double getCustoTotal(){
        return gerente.salario + getSalarioFuncionarios();
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "Nome:'" + nome + '\'' +
                ", finalizado:" + finalizado +
                ", funcionarios:" + funcionarios +
                ", gerente=" + gerente +
                ", custoTotal:" + getCustoTotal() +
                '}';
    }
}
