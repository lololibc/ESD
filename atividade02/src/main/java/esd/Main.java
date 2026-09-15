package esd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n--- MENU DA AGENDA DE CONTATOS ---");
            System.out.println("1 - Adicionar Contato (Ordenado)");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Atualizar Contato");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opcao: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {

                case 1: {
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();

                    int indice = agenda.obterIndice(nome);
                    if (indice == -1) {
                        System.out.println("Nome inválido!");
                        break;
                    }

                    boolean inserido = agenda.adicionarContato(nome, telefone);
                    if (inserido) {
                        char letra = agenda.obterLetra(indice);
                        System.out.println("Contato '" + nome + "' inserido ordenadamente na letra '"
                                + letra + "' (Indice " + indice + ")!");
                    } else {
                        System.out.println("Contato '" + nome + "' já existe!");
                    }
                    break;
                }

                case 2: {
                    System.out.print("Digite o nome do contato a remover: ");
                    String nome = scanner.nextLine();
                    int indice = agenda.obterIndice(nome);

                    if (indice != -1 && agenda.removerContato(nome)) {
                        char letra = agenda.obterLetra(indice);
                        System.out.println("Contato '" + nome + "' removido com sucesso do Vetor '" + letra + "'!");
                    } else {
                        System.out.println("Contato '" + nome + "' não encontrado!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Digite o nome do contato a buscar: ");
                    String nome = scanner.nextLine();
                    int indice = agenda.obterIndice(nome);
                    Contato encontrado = (indice == -1) ? null : agenda.buscarContato(nome);

                    if (encontrado != null) {
                        char letra = agenda.obterLetra(indice);
                        System.out.println("Contato encontrado no Vetor '" + letra + "': " + encontrado);
                    } else {
                        System.out.println("Contato '" + nome + "' não encontrado!");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Digite o nome do contato a atualizar: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    if (agenda.atualizarContato(nome, novoTelefone)) {
                        System.out.println("Contato '" + nome + "' atualizado com sucesso!");
                    } else {
                        System.out.println("Contato '" + nome + "' não encontrado!");
                    }
                    break;
                }

                case 5:
                    System.out.println("Encerrando a aplicação...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        scanner.close();
    }
}
