package esd.atividade1;

public class Gerente {
    protected String nome;
    protected double salarioBase;
    protected double salario;

    public Gerente(String nome) {
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
        return "Gerente{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                '}';
    }
}
