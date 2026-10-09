package esd;

public class Escalonador {
    private FilaCircular<Processo> fila;
    private Processo[] processos;
    private boolean[] chegadaProcessos;
    int quantum = 2;
    private int tempo;


    public Escalonador(int capacidadeFila) {
        this.fila = new FilaCircular<>(capacidadeFila);
        this.tempo = 0;
        processos = new Processo[]{
                new Processo("P1", 7, 0),
                new Processo("P2", 4, 0),
                new Processo("P3", 5, 1),
                new Processo("P4", 6, 2),
                new Processo("P5", 3, 4)
        };
        this.chegadaProcessos = new boolean[processos.length];
    }

    public void executar() {

        int processosTerminados = 0;

        while (processosTerminados < processos.length) {
            verificarChegadas();

            if (fila.isEmpty()) {
                System.out.println("Tempo " + tempo + ": fila vazia.");
                tempo++;
            } else {
                Processo processo = fila.desenfileirar();
                System.out.println(processo.getNome() + " executando...");
                processo.setStatus(Status.EXECUTANDO);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int instrucoesExecutadas;
                if(processo.getInstrucoesRestantes() < quantum) {
                    instrucoesExecutadas = processo.getInstrucoesRestantes();
                }else {
                    instrucoesExecutadas = quantum;
                }

                processo.setInstrucoesRestantes(processo.getInstrucoesRestantes() - instrucoesExecutadas);

                System.out.println(processo.getNome() + " executou " + instrucoesExecutadas + " instruções. Restam: " + processo.getInstrucoesRestantes());

                if (processo.getInstrucoesRestantes() == 0) {
                    processo.setStatus(Status.TERMINADO);
                    System.out.println(processo.getNome() + " terminou!");
                    processosTerminados++;
                } else {
                    processo.setStatus(Status.PRONTO);
                    fila.enfileirar(processo);
                }

                System.out.println();
                tempo++;
            }
        }
        System.out.println("Todos os processos foram finalizados!");
    }

    private void verificarChegadas() {

        for (int i = 0; i < processos.length; i++) {

            Processo processo = processos[i];

            if (!chegadaProcessos[i] && processo.getTempoChegada() <= tempo) {
                chegadaProcessos[i] = true;
                fila.enfileirar(processo);
                System.out.println("Tempo " + tempo + ": " + processo.getNome() + " chegou e entrou na fila.");
            }
        }
    }


}

