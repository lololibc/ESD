package esd;

public class Agenda {
    private Contato[] contatos;
    private int tamanho;

    public Agenda(int quantidade) {
        this.contatos = new Contato[quantidade];
    }

    public void adicionar(Contato contato){
        if(tamanho < contatos.length) {
            if (verificar(contato)) {
                contatos[tamanho] = contato;
                tamanho++;
            }
        } else {
            IO.println("Agenda está cheia!");
        }
    }

    public boolean verificar(Contato contato){
        for (Contato c : contatos) {
            if (c.getNome().equals(contato.getNome()) || c.getTelefone().equals(contato.getTelefone())) {
                return false;
            }
        }
        return true;
    }

    public void remover(Contato contato){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome()) || contatos[i].getTelefone().equals(contato.getTelefone())) {
                removerI(i);
                return;
            }
        }
        System.out.println("Contato não encontrado");
    }

    public void removerI(int indice){
        for (int i = indice; i < tamanho; i++) {
            contatos[i] = contatos[i+1];
        }
        contatos[tamanho-1] = null;
        tamanho--;
    }

    public Contato buscar(String nomeOuTelefone){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(nomeOuTelefone) || contatos[i].getTelefone().equals(nomeOuTelefone) ){
                return contatos[i];
            }
        }
        return null;
    }

    public void atualizar(Contato contato, String n, String t){
        for (int i = 0; i < tamanho; i++) {
            if (contatos[i].getNome().equals(contato.getNome()) || contatos[i].getTelefone().equals(contato.getTelefone())) {
                contato.setNome(n);
                contato.setTelefone(t);
            }
        }
        System.out.println("Contato não encontrado");
    }



}
