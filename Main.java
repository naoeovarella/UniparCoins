import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarteiraDigital carteira = new CarteiraDigital();

        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = lerEntradaUsuario(scanner);

            switch (opcao) {
                case 1:
                    realizarAdicaoSaldo(scanner, carteira);
                    break;
                case 2:
                    realizarPagamento(scanner, carteira);
                    break;
                case 3:
                    carteira.verificarSaldo();
                    break;
                case 4:
                    finalizarPrograma();
                    continuar = false;
                    break;
                default:
                    exibirMensagem("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\nBem-vindo à sua Carteira Digital!");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar Saldo");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Verificar Saldo");
        System.out.println("4 - Sair");
    }

    private static int lerEntradaUsuario(Scanner scanner) {
        System.out.print("Usuário: ");
        return scanner.nextInt();
    }

    private static void realizarAdicaoSaldo(Scanner scanner, CarteiraDigital carteira) {
        System.out.print("Digite o valor para adicionar ao saldo: ");
        double valorAdicionar = scanner.nextDouble();
        carteira.adicionarSaldo(valorAdicionar);
    }

    private static void realizarPagamento(Scanner scanner, CarteiraDigital carteira) {
        System.out.print("Digite o valor do pagamento: ");
        double valorPagamento = scanner.nextDouble();
        carteira.realizarPagamento(valorPagamento);
    }

    private static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    private static void finalizarPrograma() {
        exibirMensagem("Obrigado por usar a sua Carteira Digital!");
    }
}