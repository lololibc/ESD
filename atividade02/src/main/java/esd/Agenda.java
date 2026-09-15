package esd;

public class Agenda {

    private static final int tamanhoAlfabeto = 26;
    private static final int capacidadeInicial = 5;

    private Vetor<Contato>[] slots;

    @SuppressWarnings("unchecked")
    public Agenda() {
        slots = new Vetor[tamanhoAlfabeto];
        for (int i = 0; i < tamanhoAlfabeto; i++) {
            slots[i] = new Vetor<>(capacidadeInicial);
        }
    }

    public int obterIndice(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            return -1;
        }
        char primeiraLetra = Character.toUpperCase(nome.trim().charAt(0));
        if (primeiraLetra < 'A' || primeiraLetra > 'Z') {
            return -1;
        }
        return primeiraLetra - 'A';
    }

    public char obterLetra(int indice) {
        return (char) ('A' + indice);
    }

    public boolean adicionarContato(String nome, String telefone) {
        int indice = obterIndice(nome);
        if (indice == -1) {
            return false;
        }
        Vetor<Contato> vetor = slots[indice];
        if (buscarPosicao(vetor, nome) != -1) {
            return false;
        }
        vetor.inserirOrdenado(new Contato(nome, telefone));
        return true;
    }

    public boolean removerContato(String nome) {
        int indice = obterIndice(nome);
        if (indice == -1) {
            return false;
        }
        Vetor<Contato> vetor = slots[indice];
        int posicao = buscarPosicao(vetor, nome);
        if (posicao == -1) {
            return false;
        }
        vetor.remover(posicao);
        return true;
    }

    public Contato buscarContato(String nome) {
        int indice = obterIndice(nome);
        if (indice == -1) {
            return null;
        }
        Vetor<Contato> vetor = slots[indice];
        int posicao = buscarPosicao(vetor, nome);
        if (posicao == -1) {
            return null;
        }
        return vetor.ler(posicao);
    }

    public boolean atualizarContato(String nome, String novoTelefone) {
        Contato contato = buscarContato(nome);
        if (contato == null) {
            return false;
        }
        contato.setTelefone(novoTelefone);
        return true;
    }

// nao compara objetos, mas sim o nome
    private int buscarPosicao(Vetor<Contato> vetor, String nome) {
        for (int i = 0; i < vetor.obterTamanho(); i++) {
            if (vetor.ler(i).getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }
}
