package esd.atividade1;

public enum Salario {
    BASE(1000);

    private double valor;

    Salario(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
