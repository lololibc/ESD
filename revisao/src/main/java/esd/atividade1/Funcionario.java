package esd;

public class Funcionario {
    protected String nome;
    protected double salarioBase;
    protected double salario;

    public Funcionario(String nome) {
        this.nome = nome;
        this.salarioBase = Salario.BASE.getValor();
        this.salario = this.salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "nome:'" + nome + '\'' +
                ", salario:" + salario;
    }
}
