import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Prato {
    private String nome;
    private double preco;

    public Prato(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido {
    private Prato prato;
    private int quantidade;
    private double peso;

    public Pedido(Prato prato, int quantidade, double peso) {
        this.prato = prato;
        this.quantidade = quantidade;
        this.peso = peso;
    }

    public Prato getPrato() {
        return prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPeso() {
        return peso;
    }
}

class Restaurante {
    private List<Prato> pratos;
    private List<Pedido> pedidos;

    public Restaurante() {
        pratos = new ArrayList<>(); // cria uma lista vazia que naturalmente vai até 10 com o java.util.ArrayList;
        pedidos = new ArrayList<>();
    }

    public void adicionarPrato(String nome, double preco) {
        Prato prato = new Prato(nome, preco);
        pratos.add(prato);
        System.out.println("Prato adicionado: " + prato.getNome() + " - Preço: R$" + prato.getPreco());
    }

    public void adicionarPedido(int numeroPrato, int quantidade, double peso) {
        if (numeroPrato >= 1 && numeroPrato <= pratos.size()) { // caso o numero de pratos for maior que 1 e menor que o
                                                                // tamanho total da lista vai mostrar os pratos
            Prato pratoSelecionado = pratos.get(numeroPrato - 1); // prato é a classe criada em cima
            Pedido pedido = new Pedido(pratoSelecionado, quantidade, peso); // pedido é a classe criada em cima
            pedidos.add(pedido); // o add vem da biblioteca java.util.List;
            System.out.println("Pedido adicionado: " + pratoSelecionado.getNome() + " (" + pedido.getQuantidade()
                    + ") - Peso: " + pedido.getPeso() + " mlg");
        } else {
            System.out.println("Número de prato inválido!");
        }
    }

    public void exibirPratos() {
        System.out.println("Lista de Pratos:");
        for (int i = 0; i < pratos.size(); i++) {
            Prato prato = pratos.get(i);
            System.out.println((i + 1) + ". " + prato.getNome() + " - Preço: R$" + prato.getPreco());
        }
    }

    public void exibirPedidos() {
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) { // lembrando (pedidos) é a lista criada para na parte de cima
            Prato prato = pedido.getPrato();
            System.out
                    .println(
                            prato.getNome() + " (" + pedido.getQuantidade() + ") - Peso: " + pedido.getPeso() + " mlg");
        }
    }
}

public class SistemaRestaurante { // classe main para lançar os pedidos
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        do {
            exibirMenu();
            opcao = scanner.nextInt(); // biblioteca de scanner para fazer o o usuario escolher que escolha ele vai
                                       // fazer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do prato: ");
                    String nomePrato = scanner.next(); // scanner para adicionar o prato no cardapio
                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble(); // scanner para colocar o preço do prato
                    restaurante.adicionarPrato(nomePrato, preco);
                    break;
                case 2:
                    restaurante.exibirPratos(); // chama a função que exibe os pratos
                    break;
                case 3:
                    System.out.print("Digite o número do prato: ");
                    int numeroPrato = scanner.nextInt();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Digite o peso (em mlg): ");
                    double peso = scanner.nextDouble();
                    restaurante.adicionarPedido(numeroPrato, quantidade, peso);
                    break;
                case 4:
                    restaurante.exibirPedidos();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println();
        } while (opcao != 5);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("----- Sistema de Lançamento de Pedidos de Restaurante -----");
        System.out.println("1. Adicionar Prato");
        System.out.println("2. Exibir Pratos");
        System.out.println("3. Adicionar Pedido");
        System.out.println("4. Exibir Pedidos");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }
}