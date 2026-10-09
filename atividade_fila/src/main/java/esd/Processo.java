package esd;

public class Processo implements Comparable<Processo>{
    private String nome;
    private int instrucoesRestantes;
    private int tempoChegada;
    private Status status;

    public Processo(String nome, int instrucoesRestantes, int tempoChegada) {
        this.nome = nome;
        this.instrucoesRestantes = instrucoesRestantes;
        this.tempoChegada = tempoChegada;
        this.status = Status.PRONTO;
    }

    public String getNome() {
        return nome;
    }

    public int getInstrucoesRestantes() {
        return instrucoesRestantes;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public Status getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setInstrucoesRestantes(int instrucoesRestantes) {
        this.instrucoesRestantes = instrucoesRestantes;
    }

    @Override
    public int compareTo(Processo o) {
        return 0;
    }
}
